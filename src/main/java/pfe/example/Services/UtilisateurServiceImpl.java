package pfe.example.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pfe.example.DAO.UtilisateurRep;
import pfe.example.Entities.Utilisateur;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurRep utilisateurRepository;
     @Autowired
    private PasswordEncoder passwordEncoder; // Injecter l'encodeur de mot de passe


    @Override
    public Utilisateur login(String email, String motDePasse) {
        // Récupérer l'utilisateur en fonction de l'email
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur != null && passwordEncoder.matches(motDePasse, utilisateur.getMot_passe())) {
            return utilisateur;  // Le mot de passe correspond
        }

        return null;  // Le mot de passe ne correspond pas
    }
    
    
    @Override
    public Utilisateur getUtilisateurByEmail(String email) {
        // Récupérer l'utilisateur en fonction de l'email
        return utilisateurRepository.findByEmail(email);
    }

    @Override
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
    // Vérification si l'email existe déjà
    Utilisateur existingUser = utilisateurRepository.findByEmail(utilisateur.getEmail());
    if (existingUser != null) {
        throw new RuntimeException("Email already exists!");
    }
    
    // Encoder le mot de passe avant de le sauvegarder
    utilisateur.setMot_passe(passwordEncoder.encode(utilisateur.getMot_passe()));

    // Sauvegarder l'utilisateur dans la base de données
    return utilisateurRepository.save(utilisateur);
}


    @Override
    public boolean deleteUtilisateur(String email) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur != null){
            utilisateurRepository.delete(utilisateur);
            return true;
        }
        return false;
    }

    @Override
    public Utilisateur updateUtilisateur(String email, Utilisateur updatedUtilisateur) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
    if (utilisateur != null) {
        // Vérifier si le mot de passe a été mis à jour et l'encoder si nécessaire
        if (updatedUtilisateur.getMot_passe() != null) {
            // Encoder le mot de passe avant de le sauvegarder
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            utilisateur.setMot_passe(passwordEncoder.encode(updatedUtilisateur.getMot_passe()));
        }
        // Mettre à jour le rôle si nécessaire
        if (updatedUtilisateur.getRole() != null) {
            utilisateur.setRole(updatedUtilisateur.getRole());
        }
        // Ajouter d'autres mises à jour si nécessaire, par exemple, la mise à jour de l'email
        if (updatedUtilisateur.getEmail() != null && !updatedUtilisateur.getEmail().equals(utilisateur.getEmail())) {
            utilisateur.setEmail(updatedUtilisateur.getEmail());
        }

        // Sauvegarder l'utilisateur mis à jour dans la base de données
        return utilisateurRepository.save(utilisateur);
    }
    return null;
   }
    

}
