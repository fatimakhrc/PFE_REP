package pfe.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Employe")
public class Employe {
    @Id 
    @Column (name = "emp_cin" , unique =true)
    private String emp_cin;
    @Column (name = "nom_emp")
    private String nom_emp;
    @Column (name="prenom_emp")
    private String prenom_emp; 


    @ManyToOne
    @JoinColumn(name = "agence_id")  // Clé étrangère vers Agence
    private Agence agence;  // L'agence à laquelle l'employé appartient

    @ManyToOne
    @JoinColumn(name = "utilisateur_email")
    private Utilisateur utilisateur;  // Relation avec l'entité Utilisateur


    public Employe(String emp_cin, String nom_emp, String prenom_emp,Utilisateur utilisateur , Agence agence) {
        this.emp_cin = emp_cin;
        this.nom_emp = nom_emp;
        this.prenom_emp = prenom_emp;
        this.utilisateur = utilisateur;
        this.agence = agence;

    }
    
    public Employe (){

    }
    
    public String getEmp_cin() {
        return emp_cin;
    }
    public void setEmp_cin(String emp_cin) {
        this.emp_cin = emp_cin;
    }
    public String getNom_emp() {
        return nom_emp;
    }
    public void setNom_emp(String nom_emp) {
        this.nom_emp = nom_emp;
    }
    public String getPrenom_emp() {
        return prenom_emp;
    }
    public void setPrenom_emp(String prenom_emp) {
        this.prenom_emp = prenom_emp;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    public Agence getAgence() {
        return agence;
    }
    public void setAgence (Agence agence){
        this.agence=agence;
    }

   
}
