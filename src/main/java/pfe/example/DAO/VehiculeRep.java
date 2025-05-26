package pfe.example.DAO;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pfe.example.Entities.Vehicule;

@Repository
public interface VehiculeRep extends JpaRepository<Vehicule,String> {
    @Query("SELECT v.immatriculation FROM Vehicule v")
    List<String> findAllImmatriculations();

}
