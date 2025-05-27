package pfe.example.DAO;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pfe.example.Entities.Employe;
import pfe.example.Entities.Utilisateur;

@Repository
public interface UtilisateurRep extends JpaRepository<Utilisateur,String> {
    Utilisateur findByEmail(String email); 
    Optional <Utilisateur> findByEmploye(Employe employe);
}