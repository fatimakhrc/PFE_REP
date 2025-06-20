package pfe.example.Services;

import pfe.example.DTO.CreeEmployeUtilisateurDto;
import pfe.example.DTO.EmployeDashboardDto;
import pfe.example.Entities.Roles;
import pfe.example.Entities.Utilisateur;

public interface UtilisateurService {
    Utilisateur login(String email, String motDePasse);  // Méthode pour l'authentification 
    Utilisateur updateUtilisateur(String email, Utilisateur updatedUtilisateur);  // mettre a jour un utilisateur (soit operateur soit admin)
    Utilisateur getUtilisateurByEmail(String email); // recupere l'utilisateur par son email
    Utilisateur createUtilisateur(Utilisateur utilisateur );//pour creer un nouveau Utilisateur
    boolean deleteUtilisateur(String email);
    EmployeDashboardDto createUtilisateurWithEmploye(CreeEmployeUtilisateurDto dto);  // pour creer un utilisateur avec employe
    
}
