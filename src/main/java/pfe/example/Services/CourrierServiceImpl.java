package pfe.example.Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.example.DAO.CourrierRep;
//import pfe.example.DAO.TrajetRep;
import pfe.example.DAO.VehiculeRep;
import pfe.example.DTO.CreeClientCourrierDto;
import pfe.example.Entities.Courrier;
import pfe.example.Entities.StatusCourrier;
//import pfe.example.Entities.Trajet;
import pfe.example.Entities.Transporteur;
import pfe.example.Entities.Vehicule;
import pfe.example.Entities.Client;

@Service
public class CourrierServiceImpl implements CourrierService {
    @Autowired
    private CourrierRep courrierRepository;

    @Autowired
    private PricingService pricingService; // Injecter le service de pricing

    @Autowired
    private VehiculeRep vehiculeRepository;
    
    @Override
    public synchronized long genererIdCourrier() {
        LocalDate dateActuelle = LocalDate.now();
        String datePart = dateActuelle.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        // Compter le nombre de courriers envoyés aujourd'hui
        long nombreCourriersAujourdHui = courrierRepository.countByDateEnvoie(dateActuelle);

        // Générer l'ID en ajoutant le compteur au format XXXXX (5 chiffres)
        return Long.parseLong(datePart + String.format("%05d", nombreCourriersAujourdHui + 1));
    }

    @Override
    public Courrier creerCourrier(Courrier courrier) {
        courrier.setId(genererIdCourrier());
        // Calcul du prix de transmission basé sur le poids
        double prix = pricingService.prixTransmission(courrier.getPoids());
        courrier.setPrixTransmission(prix);  // Mettre à jour le prix de transmission dans l'entité

        return courrierRepository.save(courrier);
    }
    @Override
    public List<Courrier> getAllCourriers() {
        return courrierRepository.findAll();
    }

    @Override
    public Courrier getCourrierById(Long id) {
        Optional<Courrier> courrier = courrierRepository.findById(id);
        return courrier.orElse(null);
    }

    @Override
    public List<Courrier> getCourriersByStatut(StatusCourrier statut) {
        return courrierRepository.findByStatut(statut);
    }

    @Override
    public Courrier updateCourrier(Long id, Courrier courrierDetails) {
        Optional<Courrier> existingCourrier = courrierRepository.findById(id);
        if (existingCourrier.isPresent()) {
            Courrier courrier = existingCourrier.get();
            courrier.setDateEnvoie(courrierDetails.getDateEnvoie());
            courrier.setPoids(courrierDetails.getPoids());
            courrier.setStatut(courrierDetails.getStatut());
            courrier.setPrixTransmission(pricingService.prixTransmission(courrierDetails.getPoids())); // Mise à jour du prix
            return courrierRepository.save(courrier);
        }
        return null;
    }

    @Override
    public void deleteCourrier(Long id) {
        courrierRepository.deleteById(id);
    }

    @Override
    public Courrier creerCourrierDepuisDto(CreeClientCourrierDto dto) {
    Courrier courrier = new Courrier();
    courrier.setId(genererIdCourrier());
    courrier.setDateEnvoie(LocalDate.now());
    courrier.setStatut(StatusCourrier.depose); // état initial
    courrier.setPoids(dto.getPoids());
    courrier.setPrixTransmission(pricingService.prixTransmission(dto.getPoids()));

    // Informations du destinataire
    courrier.setNom_complet_dest(dto.getNom_complet_dest());
    //courrier.setCin_dest(dto.getCin_dest());
    courrier.setAdresse_dest(dto.getAdresse_dest());
    courrier.setAgenceExped(dto.getAgenceExped());
    courrier.setAgenceDest(dto.getAgenceDest());

    // Création du client expéditeur
    Client clientExp = new Client();
    clientExp.setCin(dto.getCin());
    clientExp.setNom_clt(dto.getNom_clt());
    clientExp.setPrenom_clt(dto.getPrenom_clt());
    clientExp.setClt_adress(dto.getClt_adress()); // correction ici
    clientExp.setPhone_number(dto.getPhone_number());

    courrier.setClientExped(clientExp);
    return courrierRepository.save(courrier);
}
 
    
}
