package pfe.example.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pfe.example.Entities.Agence;

@Repository
public interface AgenceRep extends JpaRepository<Agence,String> {

}