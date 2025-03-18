package pfe.example.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import pfe.example.DAO.PricingRep;
import pfe.example.Entities.Pricing;

@Service

public class PricingServiceImpl implements PricingService{
    @Autowired
    private PricingRep pr;
    @Override
    @PostConstruct
    public void createPrix(){
        Pricing prix1 = new Pricing (0.0 , 2.0 , 20.0);
        Pricing prix2 = new Pricing (2.1 , 4.0 , 35.0);
        Pricing prix3 = new Pricing (4.1 , 6.0 , 45.0);
        Pricing prix4 = new Pricing (6.1 , 8.0 , 55.0);
        Pricing prix5 = new Pricing (8.1 , 10.0 , 75.0);
        Pricing prix6 = new Pricing (10.1 , 20.0 , 150.0);
        Pricing prix7 = new Pricing (20.1 , 50.1 , 250.0);
        Pricing prix8 = new Pricing (50.1 , 100.0 , 400.0);



        pr.save(prix1);
        pr.save(prix2);
        pr.save(prix3);
        pr.save(prix4);
        pr.save(prix5);
        pr.save(prix6);
        pr.save(prix7);
        pr.save(prix8);

    }
    @Override
    public void prixTransmission() {
        //cette methode permet de calculer le prix de transmission d'un courrier

        
    }
    //on a cree les tables + creer les repository qui heritent de la bibliotheque JpaRepository + ona creer les prix qui seront
    // stockes dans la base de donnees et qui seront utilisees pour calculer le prix de transmission des courriers
    
    
}
