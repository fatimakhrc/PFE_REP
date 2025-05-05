package pfe.example.Services;

import pfe.example.Entities.Roles;
import pfe.example.Entities.Utilisateur;

public interface UtilisateurService {
    Utilisateur login(String email, String motDePasse);  // Méthode pour l'authentification 
    Utilisateur updateUtilisateur(String email, Utilisateur updatedUtilisateur);  // mettre a jour un utilisateur (soit operateur soit admin)
    Utilisateur getUtilisateurByEmail(String email); // recupere l'utilisateur par son email
    Utilisateur createUtilisateur(Utilisateur utilisateur );//pour creer un nouveau Utilisateur
    boolean deleteUtilisateur(String email);
    Utilisateur createUtilisateurAvecEmploye(String email, String motDePasse, String cin, String nom, String prenom, Roles role, String id_agence);


}
