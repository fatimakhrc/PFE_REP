package pfe.example.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/* import pfe.example.DAO.TrajetRep;*/
import pfe.example.DAO.TransporteurRep; 
import pfe.example.DAO.VehiculeRep;
import pfe.example.DTO.VehiculeDashboardDto;
import pfe.example.Entities.Agence;
/* import pfe.example.Entities.Trajet;*/
import pfe.example.Entities.Transporteur;
import pfe.example.Entities.Vehicule;
import pfe.example.DTO.CreateVehiculeDto;
import pfe.example.DAO.AgenceRep;

@Service
public class VehiculeServiceImpl implements VehiculeService{
    @Autowired
    private VehiculeRep vehiculeRepository;


    @Autowired
    private AgenceRep agenceRepository;

 

    /* @Autowired
    private TrajetRep trajetRepository;*/

    @Autowired
    private TransporteurRep transporteurRepository; 

    

    @Override
    public Optional<Vehicule> getVehiculeByImmatriculation(String imtrc) {
        // Assuming imtrc is the primary key (ID) for Vehicule
        return vehiculeRepository.findById(imtrc);
    }

    @Override
    @Transactional
    public Vehicule createVehicle(CreateVehiculeDto vehicleData) {
        Vehicule vehicule = new Vehicule();
        vehicule.setImtrc(vehicleData.getImmatriculation());
        vehicule.setType(vehicleData.getType());
        vehicule.setCapacite(vehicleData.getCapacite());

        if (vehicleData.getIdAgence() != null) {
            Agence agence = agenceRepository.findById(vehicleData.getIdAgence())
                    .orElseThrow(() -> new RuntimeException("Agence non trouvée avec l'ID: " + vehicleData.getIdAgence()));
            vehicule.setAgenceVehicule(agence);
        } else {
            throw new RuntimeException("L'ID de l'agence est obligatoire pour la création du véhicule.");
        }

        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule updateVehicle(String immatriculation, CreateVehiculeDto vehicleData) {
        Vehicule existingVehicule = vehiculeRepository.findById(immatriculation) // Use findById as immatriculation is the ID
            .orElseThrow(() -> new RuntimeException("Vehicule non trouvé avec l'immatriculation: " + immatriculation));

        existingVehicule.setType(vehicleData.getType());
        existingVehicule.setCapacite(vehicleData.getCapacite());
        
        if (vehicleData.getIdAgence() != null) {
            if (existingVehicule.getAgenceVehicule() == null || !vehicleData.getIdAgence().equals(existingVehicule.getAgenceVehicule().getId_agence())) {
                Agence newAgence = agenceRepository.findById(vehicleData.getIdAgence())
                    .orElseThrow(() -> new RuntimeException("Nouvelle agence non trouvée avec l'ID: " + vehicleData.getIdAgence()));
                existingVehicule.setAgenceVehicule(newAgence);
            }
        } else {
            // Option: Disassociate the agency if idAgence is null in the request
            existingVehicule.setAgenceVehicule(null); 
            // Alternative: Keep the existing agency (comment out above line)
            // Alternative: Throw error if agency must always be assigned (uncomment below line)
            // throw new RuntimeException("L'ID de l'agence ne peut pas être nul lors de la mise à jour.");
        }

        return vehiculeRepository.save(existingVehicule);
    }

    @Override
    public boolean deleteVehicule(String imtrc) { // Corrected return type to boolean
        if (vehiculeRepository.existsById(imtrc)) {
            vehiculeRepository.deleteById(imtrc);
            return true;
        }
        return false; // If the vehicle does not exist
    }

    @Override
    @Transactional // Ensure transactional context to load lazy AgenceVehicule
    public List<VehiculeDashboardDto> getAllVehicles() {
        return vehiculeRepository.findAll().stream()
                .map(VehiculeDashboardDto::new) // Use your existing DTO's constructor
                .collect(Collectors.toList());
    }

    @Override
    public Vehicule getVehiculeById(String imtrc) {
        return vehiculeRepository.findById(imtrc)
            .orElseThrow(() -> new RuntimeException("Vehicule not found with immatriculation: " + imtrc));
    }

    @Override
    public List<String> getAllImmatriculations() {
        // Assuming your VehiculeRep has a method to get all immatriculations
        // You might need to add this method to your VehiculeRep interface if not present.
        // Example: @Query("SELECT v.imtrc FROM Vehicule v") List<String> findAllImmatriculations();
        return vehiculeRepository.findAllImmatriculations();
    }
    
}