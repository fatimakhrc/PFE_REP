package pfe.example.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "Transporteur")
public class Transporteur {
    @Id
    @Column (name = "trs_CIN" , nullable = false)
    private String trs_Cin ;
    private String nom_complet_trs;
    private int trs_phone ;
    private String trs_adress ;
   


    @ManyToOne 
    @JoinColumn (name = "id_agence" , referencedColumnName = "id_agence")
    private Agence agenceTransporteur;

    @OneToMany (mappedBy = "transporteurVehicule")
    private List <Vehicule> vehiculeTransporteur;

    


    public Transporteur(String trs_Cin, String nom_complet_trs ,int trs_phone , String trs_adress) {
        this.trs_Cin = trs_Cin;
        this.nom_complet_trs = nom_complet_trs;
        this.trs_phone = trs_phone;
        this.trs_adress = trs_adress;
       
    }

    public Transporteur (){

    }


    
    public String getTrs_Cin() {
        return trs_Cin;
    }
    public void setTrs_Cin(String trs_Cin) {
        this.trs_Cin = trs_Cin;
    }
    public String getNom_complet_trs() {
        return nom_complet_trs;
    }
    public void setNom_complet_trs(String nom_complet_trs) {
        this.nom_complet_trs = nom_complet_trs;
    }
    public int getTrs_phone() {
        return trs_phone;
    }
    public void setTrs_phone(int trs_phone) {
        this.trs_phone = trs_phone;
    }
    public String getTrs_adress() {
        return trs_adress;
    }
    public void setTrs_adress(String trs_adress) {
        this.trs_adress = trs_adress;
    }

    
    
}
