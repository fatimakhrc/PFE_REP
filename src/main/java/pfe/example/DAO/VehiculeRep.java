package pfe.example.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pfe.example.Entities.Vehicule;

@Repository
public interface VehiculeRep extends JpaRepository<Vehicule,String> {

}
