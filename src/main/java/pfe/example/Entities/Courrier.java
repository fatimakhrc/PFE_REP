package pfe.example.Entities;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "courrier")
public class Courrier {
    @Id   // indique qu'il s'agit d'un identifiant
    @Column(name = "ID" , nullable = false) // definit des prop d'une champ dans une table ici c l'idetifiant
    private Long id;
    @Column (name = "date_envoie")
    private LocalDate dateEnvoie ;
    @Column (name = "poids")
    private double poids ;
    @Enumerated(EnumType.STRING)
    @Column (name = "statut")
    private StatusCourrier statut;
    @Column(name = "prix_transmission")
    private double prixTransmission; // Prix de transmission calculé
   
    


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cIN_DEST", referencedColumnName = "CIN" )
    private Client clientDest;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cIN_EXP", referencedColumnName = "CIN")
    private Client clientExped;
    

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "trj_id" , referencedColumnName = "trj_id")
    private Trajet trajetCourrier;


    public Courrier(Long id, LocalDate dateEnvoie, double poids, StatusCourrier statut , double prixTransmission) {
        this.id = id;
        this.dateEnvoie = dateEnvoie;
        this.poids = poids;
        this.statut = statut;  
        this.prixTransmission = prixTransmission;
    }

    public Courrier (){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalDate getDateEnvoie() {
        return dateEnvoie;
    }

    public void setDateEnvoie(LocalDate dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getPrixTransmission() {
        return prixTransmission;
    }

    public void setPrixTransmission(double prixTransmission) {
        this.prixTransmission = prixTransmission;
    }

    public StatusCourrier getStatut() {
        return statut;
    }

    public void setStatut(StatusCourrier statut) {
        this.statut = statut;
    }

    
    
}
