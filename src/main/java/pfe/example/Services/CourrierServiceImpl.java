package pfe.example.Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.example.DAO.CourrierRep;
import pfe.example.Entities.Courrier;

@Service
public class CourrierServiceImpl implements CourrierService {
    @Autowired
    private CourrierRep courrierRepository;

    @Override
    public synchronized long genererIdCourrier() {
        LocalDate dateActuelle = LocalDate.now();
        String datePart = dateActuelle.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        // Compter le nombre de courriers envoyés aujourd'hui
        long nombreCourriersAujourdHui = courrierRepository.countByDateEnvoi(dateActuelle);

        // Générer l'ID en ajoutant le compteur au format XXXXX (5 chiffres)
        return Long.parseLong(datePart + String.format("%05d", nombreCourriersAujourdHui + 1));
    }

    @Override
    public Courrier creerCourrier(Courrier courrier) {
        courrier.setId(genererIdCourrier());
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
    public List<Courrier> getCourriersByStatut(String statut) {
        return courrierRepository.findByStatut(statut);
    }

    @Override
    public Courrier updateCourrier(Long id, Courrier courrierDetails) {
        Optional<Courrier> existingCourrier = courrierRepository.findById(id);
        if (existingCourrier.isPresent()) {
            Courrier courrier = existingCourrier.get();
            courrier.setDate_envoie(courrierDetails.getDate_envoie());
            courrier.setPoids(courrierDetails.getPoids());
            courrier.setStatut(courrierDetails.getStatut());
            return courrierRepository.save(courrier);
        }
        return null;
    }

    @Override
    public void deleteCourrier(Long id) {
        courrierRepository.deleteById(id);
    }


    
}
