package pfe.example.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Trajet")
public class Trajet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trj_id", nullable = false)
    private Long trj_id;

    @Column(name = "kilometrage")
    private int kilometrage;

    @Column(name = "ville_depart")
    private String ville_depart;

    @Column(name = "ville_arrivee")
    private String ville_arrivee;

    @OneToMany(mappedBy = "trajetDepart")  
    private List<Depart> departTrajet;

    @OneToMany(mappedBy = "trajetCourrier")
    private List<Courrier> courrierTrajet;

    @OneToMany(mappedBy = "trajetVehicule")
    private List<Vehicule> vehiculeTrajet;

    @OneToMany(mappedBy = "trajetPricing")
    private List<Pricing> pricingTrajet;

    
    public Trajet(Long trj_id, int kilometrage, String ville_depart, String ville_arrivee) {
        this.trj_id = trj_id;
        this.kilometrage = kilometrage;
        this.ville_depart = ville_depart;
        this.ville_arrivee = ville_arrivee;
    }

    public Long getTrj_id() {
        return trj_id;
    }

    public void setTrj_id(Long trj_id) {
        this.trj_id = trj_id;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getVille_depart() {
        return ville_depart;
    }

    public void setVille_depart(String ville_depart) {
        this.ville_depart = ville_depart;
    }

    public String getVille_arrivee() {
        return ville_arrivee;
    }

    public void setVille_arrivee(String ville_arrivee) {
        this.ville_arrivee = ville_arrivee;
    }

    public List<Depart> getDepartTrajet() {
        return departTrajet;
    }

    public void setDepartTrajet(List<Depart> departTrajet) {
        this.departTrajet = departTrajet;
    }

    public List<Courrier> getCourrierTrajet() {
        return courrierTrajet;
    }

    public void setCourrierTrajet(List<Courrier> courrierTrajet) {
        this.courrierTrajet = courrierTrajet;
    }

    public List<Vehicule> getVehiculeTrajet() {
        return vehiculeTrajet;
    }

    public void setVehiculeTrajet(List<Vehicule> vehiculeTrajet) {
        this.vehiculeTrajet = vehiculeTrajet;
    }

    public List<Pricing> getPricingTrajet() {
        return pricingTrajet;
    }

    public void setPricingTrajet(List<Pricing> pricingTrajet) {
        this.pricingTrajet = pricingTrajet;
    }
}