package pfe.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pfe.example.Entities.Pricing;
import pfe.example.Services.PricingService;
@RequestMapping("/api/pricing")
public class PricingController {
    @Autowired
    private PricingService pricingService;

    // Endpoint pour obtenir le prix de transmission d’un poids donné
    @GetMapping("/calculate")
    public ResponseEntity<Double> calculPrix(@RequestParam("poids") double poids) {
        double prix = pricingService.prixTransmission(poids);
        return ResponseEntity.ok(prix);
    }

    // Récupérer toutes les tranches de prix
    @GetMapping("/all")
    public ResponseEntity<List<Pricing>> getAllPricing() {
        return ResponseEntity.ok(pricingService.getAllPricing());
    }

}
