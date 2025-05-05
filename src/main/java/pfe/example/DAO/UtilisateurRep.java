package pfe.example.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pfe.example.Entities.Utilisateur;

@Repository
public interface UtilisateurRep extends JpaRepository<Utilisateur,String> {
    Utilisateur findByEmail(String email); 
}