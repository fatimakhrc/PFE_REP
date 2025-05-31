package pfe.example.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table (name = "Agence")
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agence" , nullable = false )
    private String id_agence;
    @Column(name = "nom_agence")
    private String nomAgence;
    @Column(name = "adresse_agence")
    private String adresse_agence ;


    public Agence(String id_agence, String nomAgence, String adresse_agence) {
        this.id_agence = id_agence;
        this.nomAgence = nomAgence;
        this.adresse_agence = adresse_agence;
    }

    public Agence (){

    }


    @OneToMany (mappedBy = "agenceTransporteur",cascade = CascadeType.ALL)   // on utilise mappedby pour dire que la relation entre transporteur et agence est geree par agence.
    private List <Transporteur> transporteurs;

    /*@OneToMany (mappedBy = "agenceRecus",cascade = CascadeType.ALL)
    private List <Recus> recus; */

    @OneToMany(mappedBy = "agence",cascade = CascadeType.ALL)
    private List<Employe> employes;  // Liste des employés affectés à cette agence
    
    
    public String getId_agence() {
        return id_agence;
    }
    public void setId_agence(String id_agence) {
        this.id_agence = id_agence;
    }
    public String getNomAgence() {
        return nomAgence;
    }
    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }
    public String getAdresse_agence() {
        return adresse_agence;
    }
    public void setAdresse_agence(String adresse_agence) {
        this.adresse_agence = adresse_agence;
    }
    public List<Employe> getEmployes() {
        return employes;
    }
    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
    public List<Transporteur> getTransporteurs(){
        return transporteurs;
    }
    public void setTransporteurs(List<Transporteur> transporteurs) {
        this.transporteurs = transporteurs;
    }

    
}
 