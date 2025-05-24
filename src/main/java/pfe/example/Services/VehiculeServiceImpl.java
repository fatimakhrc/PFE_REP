/*package pfe.example.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.example.DAO.TrajetRep;
import pfe.example.DAO.TransporteurRep;
import pfe.example.DAO.VehiculeRep;
import pfe.example.Entities.Trajet;
import pfe.example.Entities.Transporteur;
import pfe.example.Entities.Vehicule;

@Service
public class VehiculeServiceImpl implements VehiculeService{
    @Autowired
    private VehiculeRep vehiculeRepository;

    @Autowired
    private TrajetRep trajetRepository;

    @Autowired
    private TransporteurRep transporteurRepository;

    @Override
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Optional<Vehicule> getVehiculeByImmatriculation(String imtrc) {
        return vehiculeRepository.findById(imtrc);
    }

    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

   @Override
public Vehicule updateVehicule(String imtrc, Vehicule vehiculeDetails) {
    Optional<Vehicule> existingVehicule = vehiculeRepository.findById(imtrc);
    if (existingVehicule.isPresent()) {
        Vehicule vehicule = existingVehicule.get();
        
        // Mise à jour des autres champs
        vehicule.setCapacite(vehiculeDetails.getCapacite());
        vehicule.setType(vehiculeDetails.getType());
        
        // Mise à jour des entités liées (Trajet et Transporteur)
        // Hibernate va automatiquement mettre à jour la clé étrangère 'trj_id' et 'trs_CIN'
        if (vehiculeDetails.getTrajetVehicule() != null) {
            Trajet trajet = trajetRepository.findById(vehiculeDetails.getTrajetVehicule().getTrj_id())
                                           .orElseThrow(() -> new RuntimeException("Trajet non trouvé"));
            vehicule.setTrajetVehicule(trajet);
        }

        if (vehiculeDetails.getTransporteurVehicule() != null) {
            Transporteur transporteur = transporteurRepository.findById(vehiculeDetails.getTransporteurVehicule().getTrs_Cin())
                                                               .orElseThrow(() -> new RuntimeException("Transporteur non trouvé"));
            vehicule.setTransporteurVehicule(transporteur);
        }

        // Sauvegarde de l'entité mise à jour
        return vehiculeRepository.save(vehicule);
    }
    return null;
}

    @Override
    public boolean deleteVehicule(String imtrc) {
        if (vehiculeRepository.existsById(imtrc)) {
            vehiculeRepository.deleteById(imtrc);
            return true;
        }
        return false; // Si le véhicule n'existe pas
    }
    @Override
    public Vehicule getVehiculeById(String imtrc) {
        return vehiculeRepository.findById(imtrc)
            .orElseThrow(() -> new RuntimeException("Vehicule not found"));
    }

    @Override
    public List<String> getAllImmatriculations() {
        return vehiculeRepository.findAllImmatriculations();
    }
    
}
*/