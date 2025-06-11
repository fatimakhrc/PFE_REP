package pfe.example.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pfe.example.Entities.Agence;
import pfe.example.Entities.Transporteur;
import java.util.List;


@Repository
public interface TransporteurRep extends JpaRepository <Transporteur,String> {
    

} 