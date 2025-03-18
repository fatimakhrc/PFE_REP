package pfe.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Pricing")
public class Pricing {
    @Id
    @Column(name = "trj_id")
    private String trj_id ;
    @Column(name="poids_min")
    private Double poids_min ;
    @Column(name="poids_max")
    private Double poids_max ;
    @Column(name="prix_uni")
    private Double prix_uni ;
    

    @ManyToOne
    @JoinColumn(name = "trj_id" , referencedColumnName = "trj_id")
    private Trajet trajetPricing;

    
    public Pricing(String trj_id, Double poids_min, Double poids_max, Double prix_uni ) {
        this.trj_id = trj_id;
        this.poids_min = poids_min;
        this.poids_max = poids_max;
        this.prix_uni = prix_uni;
        
    }


    public Pricing() {
        
    }


    public Pricing(double d, double e, double f) {
        //TODO Auto-generated constructor stub
    }


    public String getTrj_id() {
        return trj_id;
    }
    public void setTrj_id(String trj_id) {
        this.trj_id = trj_id;
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
    

    
}
