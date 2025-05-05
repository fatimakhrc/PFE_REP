package pfe.example.DataInitialization;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import pfe.example.DAO.RoleRep;
import pfe.example.DAO.UtilisateurRep;
import pfe.example.Entities.Roles;
import pfe.example.Entities.Utilisateur;

@Component
public class Initialisation implements CommandLineRunner {

    @Autowired
    private RoleRep rolesRepository;

    @Autowired
    private UtilisateurRep utilisateurRep;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        // Création du rôle ADMIN s'il n'existe pas
        Roles adminRole = rolesRepository.findRoleByNom("ADMIN")
                .orElseGet(() -> {
                    Roles role = new Roles();
                    role.setNom("ADMIN");
                    return rolesRepository.save(role);
                });

        // Création du rôle OPERATEUR s'il n'existe pas
        rolesRepository.findRoleByNom("OPERATEUR")
                .orElseGet(() -> {
                    Roles role = new Roles();
                    role.setNom("OPERATEUR");
                    return rolesRepository.save(role);
                });
        // Création du rôle TRANSPORTEUR s'il n'existe pas
        rolesRepository.findRoleByNom("TRANSPORTEUR")
                .orElseGet(() -> {
                    Roles role = new Roles();
                    role.setNom("TRANSPORTEUR");
                    return rolesRepository.save(role);
                });
                
        // Création de l'utilisateur admin
        String email = "admin1@gmail.com";
        if (!utilisateurRep.existsById(email)) {
            Utilisateur admin = new Utilisateur();
            admin.setEmail(email);
            admin.setMot_passe(passwordEncoder.encode("admin123"));
            admin.setRole(adminRole);
            utilisateurRep.save(admin);
            System.out.println("✅ Utilisateur ADMIN créé avec succès !");
        } else {
            System.out.println("ℹ️ L'utilisateur ADMIN existe déjà.");
        }
    }
}
