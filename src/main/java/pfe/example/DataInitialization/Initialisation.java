package pfe.example.DataInitialization;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import pfe.example.DAO.EmployeRep;
import pfe.example.DAO.PricingRep;
import pfe.example.DAO.RoleRep;
import pfe.example.DAO.UtilisateurRep;
import pfe.example.Entities.Employe;
import pfe.example.Entities.Pricing;
import pfe.example.Entities.Roles;
import pfe.example.Entities.Transporteur;
import pfe.example.Entities.Utilisateur;
import pfe.example.DAO.AgenceRep;
import pfe.example.Entities.Agence;

@Component
@Transactional // Annotation pour indiquer que cette classe gère les transactions
public class Initialisation implements CommandLineRunner {

    @Autowired
    private RoleRep rolesRepository;

    @Autowired
    private EmployeRep employeRep;

    @Autowired
    private UtilisateurRep utilisateurRep;

   @Autowired
    private PricingRep pricingRep;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AgenceRep agenceRep;

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
        employe.setEmpCin("D1234");
        employe.setNom_emp("admin");
        employe.setPrenom_emp("adminTest");
        employe.setEmp_adresse("123 Admin Street");
        employe.setEmp_phone("0123456789");
        employe.setRole(adminRole); // Associer le rôle ADMIN
        Employe savedEmploye = employeRep.save(employe);

        // Création de l'utilisateur
        Utilisateur admin = new Utilisateur();
        admin.setEmail(email);
        admin.setMot_passe(passwordEncoder.encode("admin123"));
        admin.setRole(adminRole);
        admin.setEmploye(savedEmploye); // Lier l'employé
        utilisateurRep.save(admin);

        System.out.println(" Utilisateur ADMIN et Employé associés créés !");
    } else {
        System.out.println("L'utilisateur ADMIN existe déjà.");
    }
        // Création de l'opérateur si l'utilisateur n'existe pas
    String emailOperateur = "operateur1@gmail.com";
    if (utilisateurRep.findByEmail(emailOperateur) == null) {

        // Récupérer le rôle OPERATEUR
        Roles operateurRole = rolesRepository.findRoleByNom("OPERATEUR")
            .orElseThrow(() -> new RuntimeException("Rôle OPERATEUR introuvable"));

        // Création de l'employé opérateur
        Employe employeOperateur = new Employe();
        employeOperateur.setEmpCin("O5678");
        employeOperateur.setNom_emp("Operateur");
        employeOperateur.setPrenom_emp("Test");
        employeOperateur.setEmp_adresse("456 Operator Street");
        employeOperateur.setEmp_phone("098765432");
        employeOperateur.setRole(operateurRole); // Associer le rôle OPERATEUR
        Employe savedOperateur = employeRep.save(employeOperateur);

        // Création du compte utilisateur opérateur
        Utilisateur operateur = new Utilisateur();
        operateur.setEmail(emailOperateur);
        operateur.setMot_passe(passwordEncoder.encode("operateur123"));
        operateur.setRole(operateurRole);
        operateur.setEmploye(savedOperateur); // Lier employé et utilisateur

        utilisateurRep.save(operateur);

        System.out.println(" Utilisateur OPERATEUR et Employé associés créés !");
    } else {
        System.out.println(" L'utilisateur OPERATEUR existe déjà.");
    }

    //creation de transporteur 
   
            
    /* String nomAgence = "Agence Centrale";
    if (agenceRep.findByNomAgence(nomAgence).isEmpty()) {
    Agence agence = new Agence();
    agence.setNomAgence(nomAgence);
    agence.setAdresse_agence("123 Rue Principale, Casablanca");

    agenceRep.save(agence);
    System.out.println("Agence créée : " + nomAgence);
    } else {
        System.out.println("L'agence " + nomAgence + " existe déjà.");
    } */


        // Création des tranches de prix s'il n'y en a pas déjà
        if (pricingRep.count() == 0) {
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
        }
    }
}

