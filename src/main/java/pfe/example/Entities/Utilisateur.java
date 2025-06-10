package pfe.example.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Utilisateur")
public class Utilisateur {
    @Id
    @Column (name = "email" , unique = true)
    private String email;
    @Column (unique = true)
    private String mot_passe;
    

    @ManyToOne(fetch = FetchType.EAGER)// Cela permet de récupérer le rôle de l'utilisateur au moment de la connexion
    @JoinColumn(name = "id_role", referencedColumnName = "id_role") 
    private Roles role; // Le rôle de l'utilisateur

    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private Employe employe;


    public Utilisateur(String email, String mot_passe, Roles role) {
        this.role = role;
        this.email = email;
        this.mot_passe = mot_passe;
        
    }

    public Utilisateur (){

    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMot_passe() {
        return mot_passe;
    }
    public void setMot_passe(String mot_passe) {
        this.mot_passe = mot_passe;
    }
    public Roles getRole() {
        return role;
    }


    public void setRole(Roles role) {
        this.role = role;
    }

    public Employe getEmploye() {
        return employe;
    }
    
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    
}
