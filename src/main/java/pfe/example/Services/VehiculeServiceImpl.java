package pfe.example.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.example.DAO.VehiculeRep;
import pfe.example.Entities.Vehicule;

@Service
public class VehiculeServiceImpl implements VehiculeService{
    @Autowired
    private VehiculeRep vehiculeRepository;

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
            vehicule.setCapacite(vehiculeDetails.getCapacite());
            vehicule.setType(vehiculeDetails.getType());
            vehicule.setTrajetId(vehiculeDetails.getTrajetId());
            vehicule.setTrs_cin(vehiculeDetails.getTrs_cin());
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

        
    
}
