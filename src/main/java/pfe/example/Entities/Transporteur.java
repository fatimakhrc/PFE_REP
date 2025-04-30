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
    private String trs_nom ;
    private String trs_prenom ;
    private int trs_phone ;
    private String trs_adress ;
   


    @ManyToOne 
    @JoinColumn (name = "id_agence" , referencedColumnName = "id_agence",insertable = false, updatable = false)
    private Agence agenceTransporteur;

    @OneToMany (mappedBy = "transporteurVehicule")
    private List <Vehicule> vehiculeTransporteur;

    


    public Transporteur(String trs_Cin, String trs_nom, String trs_prenom, int trs_phone, String trs_adress) {
        this.trs_Cin = trs_Cin;
        this.trs_nom = trs_nom;
        this.trs_prenom = trs_prenom;
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
    public String getTrs_nom() {
        return trs_nom;
    }
    public void setTrs_nom(String trs_nom) {
        this.trs_nom = trs_nom;
    }
    public String getTrs_prenom() {
        return trs_prenom;
    }
    public void setTrs_prenom(String trs_prenom) {
        this.trs_prenom = trs_prenom;
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
