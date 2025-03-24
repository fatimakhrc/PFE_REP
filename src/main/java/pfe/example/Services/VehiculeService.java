package pfe.example.Services;

import java.util.List;
import java.util.Optional;

import pfe.example.Entities.Vehicule;

public interface VehiculeService {
    // Méthode pour récupérer tous les véhicules
    List<Vehicule> getAllVehicules();

    // Méthode pour récupérer un véhicule par son immatriculation
    Optional<Vehicule> getVehiculeByImmatriculation(String imtrc);

    // Méthode pour ajouter un nouveau véhicule
    Vehicule addVehicule(Vehicule vehicule);

    // Méthode pour mettre à jour un véhicule existant
    Vehicule updateVehicule(String imtrc, Vehicule vehiculeDetails);

    // Méthode pour supprimer un véhicule par son immatriculation
    boolean deleteVehicule(String imtrc);

    //methode pour avoir une vehicule selon son immatriculation
    Vehicule getVehiculeById(String imtrc);

}

    

