package pfe.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Employe")
public class Employe {
    @Id 
    @Column (name = "emp_cin" , unique =true)
    private String empCin;
    @Column (name = "nom_emp")
    private String nom_emp;
    @Column (name="prenom_emp")
    private String prenom_emp; 
    @Column (name = "emp_phone")
    private String emp_phone;
    @Column (name = "emp_adresse")
    private String emp_adresse;


    @ManyToOne
    @JoinColumn(name = "agence_id")  // Clé étrangère vers Agence
    private Agence agence;  // L'agence à laquelle l'employé appartient

    @OneToOne
    @JoinColumn(name = "utilisateur_email")
    private Utilisateur utilisateur;

    
    public Employe(String empCin, String nom_emp, String prenom_emp, String emp_phone, String emp_adresse,
            Agence agence, Utilisateur utilisateur) {
        this.empCin = empCin;
        this.nom_emp = nom_emp;
        this.prenom_emp = prenom_emp;
        this.emp_phone = emp_phone;
        this.emp_adresse = emp_adresse;
        this.agence = agence;
        this.utilisateur = utilisateur;
    }

    public Employe (){

    }

    public String getEmpCin() {
        return empCin;
    }

    public void setEmpCin(String empCin) {
        this.empCin = empCin;
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

    public String getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(String emp_phone) {
        this.emp_phone = emp_phone;
    }

    public String getEmp_adresse() {
        return emp_adresse;
    }

    public void setEmp_adresse(String emp_adresse) {
        this.emp_adresse = emp_adresse;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    

   
}
