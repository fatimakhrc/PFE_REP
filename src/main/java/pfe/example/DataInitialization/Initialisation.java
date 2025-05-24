package pfe.example.DataInitialization;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import pfe.example.DAO.EmployeRep;
//import pfe.example.DAO.PricingRep;
import pfe.example.DAO.RoleRep;
import pfe.example.DAO.UtilisateurRep;
import pfe.example.Entities.Employe;
//import pfe.example.Entities.Pricing;
import pfe.example.Entities.Roles;
import pfe.example.Entities.Utilisateur;

@Component
@Transactional // Annotation pour indiquer que cette classe gère les transactions
public class Initialisation implements CommandLineRunner {

    @Autowired
    private RoleRep rolesRepository;

    @Autowired
    private EmployeRep employeRep;

    @Autowired
    private UtilisateurRep utilisateurRep;

   /* @Autowired
    private PricingRep pricingRep;*/

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
                
        String email = "admin1@gmail.com";
    if (utilisateurRep.findByEmail(email) == null) {

        // Création de l'employé
        Employe employe = new Employe();
        employe.setEmp_cin("D1234");
        employe.setNom_emp("flan");
        employe.setPrenom_emp("flani");
        Employe savedEmploye = employeRep.save(employe);

        // Création de l'utilisateur
        Utilisateur admin = new Utilisateur();
        admin.setEmail(email);
        admin.setMot_passe(passwordEncoder.encode("admin123"));
        admin.setRole(adminRole);
        admin.setEmploye(savedEmploye); // Lier l'employé
        utilisateurRep.save(admin);

        System.out.println("✅ Utilisateur ADMIN et Employé associés créés !");
    } else {
        System.out.println("ℹ️ L'utilisateur ADMIN existe déjà.");
    }
        // Création des tranches de prix s'il n'y en a pas déjà
       /* if (pricingRep.count() == 0) {
            Pricing prix1 = new Pricing(0.0, 2.0, 20.0);
            Pricing prix2 = new Pricing(2.1, 4.0, 35.0);
            Pricing prix3 = new Pricing(4.1, 6.0, 45.0);
            Pricing prix4 = new Pricing(6.1, 8.0, 55.0);
            Pricing prix5 = new Pricing(8.1, 10.0, 75.0);
            Pricing prix6 = new Pricing(10.1, 20.0, 250.0);
            Pricing prix7 = new Pricing(20.1, 50.1, 400.0);
            Pricing prix8 = new Pricing(50.1, 100.0, 1500.0);

            pricingRep.save(prix1);
            pricingRep.save(prix2);
            pricingRep.save(prix3);
            pricingRep.save(prix4);
            pricingRep.save(prix5);
            pricingRep.save(prix6);
            pricingRep.save(prix7);
            pricingRep.save(prix8);

            System.out.println("✅ Tranches de prix enregistrées !");
        } else {
            System.out.println("ℹ️ Les tranches de prix existent déjà.");
        }*/
    }
}

