/*package pfe.example.Services;



import java.util.Comparator;
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
    public double prixTransmission(double poidsTotal) {
        List<Pricing> allPricings = pr.findAll();
    allPricings.sort(Comparator.comparing(Pricing::getPoids_min));
    double prixTotal = 0.0;
    double poidsRestant = poidsTotal;

    for (Pricing pricing : allPricings) {
        double min = pricing.getPoids_min();
        double max = pricing.getPoids_max();
        double tranchePoids = max - min;
        double prixUni = pricing.getPrix_uni();

        if (poidsRestant <= 0) break;

        if (poidsRestant >= tranchePoids) {
            prixTotal += prixUni;
            poidsRestant -= tranchePoids;
        } else {
            // Prend une portion proportionnelle du prix
            double portion = (poidsRestant / tranchePoids) * prixUni;
            prixTotal += portion;
            poidsRestant = 0;
        }
    }

    return prixTotal;
    }

    @Override
    public List<Pricing> getAllPricing() {
        return pr.findAll();
    }
    //on a cree les tables + creer les repository qui heritent de la bibliotheque JpaRepository + ona creer les prix qui seront
    // stockes dans la base de donnees et qui seront utilisees pour calculer le prix de transmission des courriers
    
    
}
*/