package pfe.example.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Transporteur")
public class Transporteur {
    @Id
    @Column (name = "trs_CIN" , nullable = false)
    private String trs_Cin ;
    private String nom_trs;
    private String prenom_trs;
    private int trs_phone ;
    private String trs_adress ;
   


    @ManyToOne 
    @JoinColumn (name = "id_agence" , referencedColumnName = "id_agence")
    private Agence agenceTransporteur;

    @OneToOne
    @JoinColumn(name = "immatriculation")
    private Vehicule vehiculeTransporteur;

    @OneToOne(mappedBy = "transporteur")
    private Employe employe;

    @ManyToOne 
    @JoinColumn(name = "id_role")
    private Roles role;

    


    public Transporteur(String trs_Cin, String nom_trs ,String prenom_trs,int trs_phone , String trs_adress) {
        this.trs_Cin = trs_Cin;
        this.nom_trs = nom_trs;
        this.prenom_trs = prenom_trs;
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

    public String getNom_trs() {
        return nom_trs;
    }

    public void setNom_trs(String nom_trs) {
        this.nom_trs = nom_trs;
    }

    public String getPrenom_trs() {
        return prenom_trs;
    }

    public void setPrenom_trs(String prenom_trs) {
        this.prenom_trs = prenom_trs;
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

    public Agence getAgenceTransporteur() {
        return agenceTransporteur;
    }

    public void setAgenceTransporteur(Agence agenceTransporteur) {
        this.agenceTransporteur = agenceTransporteur;
    }

    public Vehicule getVehiculeTransporteur() {
        return vehiculeTransporteur;
    }

    public void setVehiculeTransporteur(Vehicule vehiculeTransporteur) {
        this.vehiculeTransporteur = vehiculeTransporteur;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

     
}