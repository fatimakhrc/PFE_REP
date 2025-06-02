package pfe.example.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Pricing")
public class Pricing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pricing_id")
    private int pricing_id ;
    @Column(name="poids_min")
    private Double poids_min ;
    @Column(name="poids_max")
    private Double poids_max ;
    @Column(name="prix_uni")
    private Double prix_uni ;
    

    /* @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trj_id", referencedColumnName = "trj_id") 
    private Trajet trajetPricing; */
    

    public Pricing(Double poids_min, Double poids_max, Double prix_uni) {
        this.poids_min = poids_min;
        this.poids_max = poids_max;
        this.prix_uni = prix_uni;
    }


    public Pricing(int pricing_id, Double poids_min, Double poids_max, Double prix_uni ) {
        this.pricing_id = pricing_id;
        this.poids_min = poids_min;
        this.poids_max = poids_max;
        this.prix_uni = prix_uni;
        
    }


    public Pricing() {
        
    }

    public Double getPoids_min() {
        return poids_min;
    }
    public void setPoids_min(Double poids_min) {
        this.poids_min = poids_min;
    }
    public Double getPoids_max() {
        return poids_max;
    }
    public void setPoids_max(Double poids_max) {
        this.poids_max = poids_max;
    }
    public Double getPrix_uni() {
        return prix_uni;
    }
    public void setPrix_uni(Double prix_uni) {
        this.prix_uni = prix_uni;
    }


    public int getPricing_id() {
        return pricing_id;
    }


    public void setPricing_id(int pricing_id) {
        this.pricing_id = pricing_id;
    }


   /*  public Trajet getTrajetPricing() {
        return trajetPricing;
    }


    public void setTrajetPricing(Trajet trajetPricing) {
        this.trajetPricing = trajetPricing;
    }
     */

    
}
