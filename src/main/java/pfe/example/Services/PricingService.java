package pfe.example.Services;

import java.util.List;

import pfe.example.Entities.Pricing;

public interface PricingService {
    void createPrix();
    double prixTransmission(double poids);
    List<Pricing> getAllPricing();

    
}
