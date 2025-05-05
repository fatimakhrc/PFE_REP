package pfe.example.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pfe.example.Entities.Trajet;

@Repository
public interface TrajetRep extends JpaRepository <Trajet,Long>{

}