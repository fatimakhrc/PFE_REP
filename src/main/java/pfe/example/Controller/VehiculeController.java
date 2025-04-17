package pfe.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pfe.example.Entities.Vehicule;
import pfe.example.Services.VehiculeService;

@RestController
@RequestMapping("/api/vehicule")
public class VehiculeController {
    @Autowired
    private VehiculeService vehiculeService;
    // Endpoint pour récupérer tous les véhicules
    @GetMapping("/")
    public ResponseEntity<List<Vehicule>> getAllVehicules() {
        List<Vehicule> vehicules = vehiculeService.getAllVehicules();
        return new ResponseEntity<>(vehicules, HttpStatus.OK);
    }

    // Endpoint pour récupérer un véhicule par son immatriculation
    @GetMapping("/{imtrc}")
    public ResponseEntity<Vehicule> getVehiculeByImmatriculation(@PathVariable String imtrc) {
        Optional<Vehicule> vehicule = vehiculeService.getVehiculeByImmatriculation(imtrc);
        return vehicule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Endpoint pour ajouter un nouveau véhicule
    @PostMapping("/")
    public ResponseEntity<Vehicule> addVehicule(@RequestBody Vehicule vehicule) {
        Vehicule createdVehicule = vehiculeService.addVehicule(vehicule);
        return new ResponseEntity<>(createdVehicule, HttpStatus.CREATED);
    }
    // Endpoint pour mettre à jour un véhicule existant
    @PutMapping("/{imtrc}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable String imtrc, @RequestBody Vehicule vehiculeDetails) {
        Vehicule updatedVehicule = vehiculeService.updateVehicule(imtrc, vehiculeDetails);
        return updatedVehicule != null ? new ResponseEntity<>(updatedVehicule, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint pour supprimer un véhicule
    @DeleteMapping("/{imtrc}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable String imtrc) {
        boolean deleted = vehiculeService.deleteVehicule(imtrc);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                       : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
    
    


