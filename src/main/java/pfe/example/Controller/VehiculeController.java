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
import pfe.example.DTO.CreateVehiculeDto;

import pfe.example.DTO.VehiculeDashboardDto;
import pfe.example.Entities.Vehicule;
import pfe.example.Services.VehiculeService;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/vehicule")
@PreAuthorize("hasRole('ADMIN') ")
public class VehiculeController {
    @Autowired
    private VehiculeService vehiculeService;

    // Endpoint pour récupérer tous les véhicules (affichage Dashboard)
    @GetMapping("/getAll")
    public ResponseEntity<List<VehiculeDashboardDto>> getAllVehicles() {
        List<VehiculeDashboardDto> vehicles = vehiculeService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    // Endpoint pour récupérer un véhicule par son immatriculation (entité complète)
    @GetMapping("/{imtrc}")
    public ResponseEntity<Vehicule> getVehiculeByImmatriculation(@PathVariable String imtrc) {
        // Using getVehiculeByImmatriculation from service that returns Optional
        Optional<Vehicule> vehicule = vehiculeService.getVehiculeByImmatriculation(imtrc);
        return vehicule.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Endpoint pour ajouter un nouveau véhicule
    // Request Body: CreateVehiculeDto (immatriculation, type, capacite, idAgence)
    // Response: Vehicule (the saved entity)
    @PostMapping("/create")
    public ResponseEntity<Vehicule> addVehicle(@RequestBody CreateVehiculeDto vehicleData) {
        Vehicule savedVehicule = vehiculeService.createVehicle(vehicleData);
        // You could return a DTO here for consistent API responses, e.g.:
        // return ResponseEntity.status(HttpStatus.CREATED).body(new VehiculeDashboardDto(savedVehicule));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVehicule);
    }

    // Endpoint pour mettre à jour un véhicule existant
    // Path Variable: imtrc (immatriculation to identify vehicle)
    // Request Body: CreateVehiculeDto (updated type, capacite, and potentially new idAgence)
    @PutMapping("/{imtrc}") // Changed path variable to imtrc for consistency
    public ResponseEntity<Vehicule> updateVehicle(@PathVariable String imtrc, @RequestBody CreateVehiculeDto vehicleData) {
        Vehicule updatedVehicule = vehiculeService.updateVehicle(imtrc, vehicleData); // Pass imtrc
        return ResponseEntity.ok(updatedVehicule);
    }

    // Endpoint pour supprimer un véhicule
    // Path Variable: imtrc (immatriculation of vehicle to delete)
    @DeleteMapping("/{imtrc}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable String imtrc) {
        boolean deleted = vehiculeService.deleteVehicule(imtrc);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                       : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}