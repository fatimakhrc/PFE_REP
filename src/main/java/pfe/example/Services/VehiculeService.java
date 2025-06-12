package pfe.example.Services;

import java.util.List;
import java.util.Optional;
import pfe.example.DTO.CreateVehiculeDto;

import pfe.example.DTO.VehiculeDashboardDto;
import pfe.example.Entities.Vehicule;

public interface VehiculeService {
    List<VehiculeDashboardDto> getAllVehicles();

    // Méthode pour récupérer un véhicule par son immatriculation, renvoie l'entité complète
    // Utilisé généralement pour des opérations internes ou des détails spécifiques non couverts par DTO
    Optional<Vehicule> getVehiculeByImmatriculation(String imtrc);

    // Méthode pour ajouter un nouveau véhicule
    Vehicule createVehicle(CreateVehiculeDto vehicleData);

    // Méthode pour mettre à jour un véhicule existant
    Vehicule updateVehicle(String immatriculation, CreateVehiculeDto vehicleData); // Corrected method name to match implementation

    // Méthode pour supprimer un véhicule par son immatriculation
    boolean deleteVehicule(String imtrc); // Corrected return type to boolean

    // Méthode pour obtenir une seule entité Vehicule par immatriculation
    // This is essentially a non-Optional version of getVehiculeByImmatriculation
    Vehicule getVehiculeById(String imtrc); // Renamed for clarity and consistency with entity retrieval

    // Méthode pour récupérer toutes les immatriculations (Strings)
    List<String> getAllImmatriculations();
}

