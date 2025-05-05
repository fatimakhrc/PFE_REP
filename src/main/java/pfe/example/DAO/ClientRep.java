package pfe.example.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pfe.example.Entities.Client;

@Repository
public interface ClientRep extends JpaRepository<Client,String> {
    //le premier parametre "Client" indique le type de l'entite qu'on veux gerer avec ce repository 
    // le deuxieme parametre "String" indique le type de l'identifiant (cle primaire)
    
}