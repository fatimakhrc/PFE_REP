package pfe.example.transport_courriers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "pfe.example.Entities") // Indique le package des entités
public class TransportCourriersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportCourriersApplication.class, args);
	}

}
