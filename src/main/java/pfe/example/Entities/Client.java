package pfe.example.Entities;

import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "Client")
public class Client {
    @Id
    @Column(name = "CIN",length = 15 , nullable = false)
    private String cin ;
    @Column(name="nom_clt")
    private String nom_clt ;
    @Column(name="prenom_clt")
    private String prenom_clt ;
    @Column(name="clt_adress")
    private String clt_adress ;
    @Column(name="phone_number")
    private int phone_number ;
    @Column(name="email")
    private String email ;
    @Column(name="role")
    private String role ;

    public Client(String cin, String nom_clt, String prenom_clt, String clt_adress, int phone_number, String email,
            String role) {
        this.cin = cin;
        this.nom_clt = nom_clt;
        this.prenom_clt = prenom_clt;
        this.clt_adress = clt_adress;
        this.phone_number = phone_number;
        this.email = email;
        this.role = role;
    }


    @OneToMany(mappedBy = "clientDest",cascade = CascadeType.ALL)
    private List<Courrier> courriersDest;
  
    @OneToMany(mappedBy = "clientExped",cascade = CascadeType.ALL)
    private List<Courrier> courriersExped;
    

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom_clt() {
        return nom_clt;
    }

    public void setNom_clt(String nom_clt) {
        this.nom_clt = nom_clt;
    }

    public String getPrenom_clt() {
        return prenom_clt;
    }

    public void setPrenom_clt(String prenom_clt) {
        this.prenom_clt = prenom_clt;
    }

    public String getClt_adress() {
        return clt_adress;
    }

    public void setClt_adress(String clt_adress) {
        this.clt_adress = clt_adress;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    

    
    
}