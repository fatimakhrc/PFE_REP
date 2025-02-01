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
@Table (name = "Trajet")
public class Trajet {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column ( name = "trj_id" , nullable = false )
    private String trj_id ;
    @Column (name = "killometrage ")
    private int killomertage ;
    @Column (name = "ville_depart")
    private String ville_depart ;
    @Column (name = "ville_arrivee")
    private String ville_arrivee ;

    
    @OneToMany (mappedBy = "Trajet")
    private List <Courrier> courrierTrajet;

    @OneToMany (mappedBy = "Vehicule")
    private List <Vehicule> vehiculeTrajet;

    @OneToMany (mappedBy = "Pricing")
    private List <Pricing> pricingTrajet;
    
    @OneToMany (mappedBy = "Depart")
    private List <Depart> departTrajet;


    public Trajet(String trj_id, int killomertage, String ville_depart, String ville_arrivee) {
        this.trj_id = trj_id;
        this.killomertage = killomertage;
        this.ville_depart = ville_depart;
        this.ville_arrivee = ville_arrivee;
    }

    
    public String getTrj_id() {
        return trj_id;
    }
    public void setTrj_id(String trj_id) {
        this.trj_id = trj_id;
    }
    public int getKillomertage() {
        return killomertage;
    }
    public void setKillomertage(int killomertage) {
        this.killomertage = killomertage;
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



    
}
