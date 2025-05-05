package pfe.example.transport_courriers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import pfe.example.DAO.RoleRep;
import pfe.example.DAO.UtilisateurRep;
import pfe.example.Entities.Roles;
import pfe.example.Entities.Utilisateur;
import pfe.example.Services.UtilisateurService;

@SpringBootApplication
@EntityScan(basePackages = "pfe.example.Entities") // Indique le package des entités
public class TransportCourriersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportCourriersApplication.class, args);
	}

}
