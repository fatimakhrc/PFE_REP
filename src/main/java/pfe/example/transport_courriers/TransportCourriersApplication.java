package pfe.example.transport_courriers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@EntityScan(basePackages = "pfe.example.Entities")
@ComponentScan(basePackages = "pfe.example")        // Tous les composants, services, initialisations
@EnableJpaRepositories(basePackages = "pfe.example.DAO") // Repositories JPA
public class TransportCourriersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportCourriersApplication.class, args);
	}

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
