package pfe.example.DAO;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pfe.example.Entities.Courrier;
import pfe.example.Entities.StatusCourrier;

@Repository
public interface CourrierRep  extends JpaRepository <Courrier,Long>{
    long countByDateEnvoie(LocalDate dateEnvoie);
    List<Courrier> findByStatut(StatusCourrier statut);
    
} 