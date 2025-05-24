/* package pfe.example.DAO;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import pfe.example.Entities.Agence;

@Repository
public interface AgenceRep extends JpaRepository<Agence,String> {
    @Query("SELECT a.adresse_agence FROM Agence a ")
    List<String> findAllAdresses();
} */