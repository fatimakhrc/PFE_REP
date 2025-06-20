package pfe.example.DAO;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pfe.example.Entities.Agence;
import pfe.example.Entities.Vehicule;

@Repository
public interface VehiculeRep extends JpaRepository<Vehicule,String> {
    @Query("SELECT v.immatriculation FROM Vehicule v")
    List<String> findAllImmatriculations();

    // Méthode pour récupérer un véhicule par son immatriculation
    Optional<Vehicule> findByImmatriculation(String immatriculation);

    //permet de recuperer les vehicules d'une agence 
    List<Vehicule> findByAgenceVehicule(Agence agence);

}
