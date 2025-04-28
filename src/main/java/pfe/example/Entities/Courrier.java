package pfe.example.Entities;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "courrier")
public class Courrier {
    @Id   // indique qu'il s'agit d'un identifiant
    @Column(name = "ID" , nullable = false) // definit des prop d'une champ dans une table ici c l'idetifiant
    private Long id;
    @Column (name = "date_envoie")
    private Date date_envoie ;
    @Column (name = "poids")
    private double poids ;
    @Enumerated(EnumType.STRING)
    @Column (name = "statut")
    private StatusCourrier statut;
   
    


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cIN_DEST", referencedColumnName = "CIN" )
    private Client clientDest;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cIN_EXP", referencedColumnName = "CIN")
    private Client clientExped;
    


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trj_id" , referencedColumnName = "trj_id")
    private Trajet trajetCourrier;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Recus recus;

    public Courrier(Long id, Date date_envoie, double poids, StatusCourrier statut) {
        this.id = id;
        this.date_envoie = date_envoie;
        this.poids = poids;
        this.statut = statut; //paye ou pas 
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getDate_envoie() {
        return date_envoie;
    }

    public void setDate_envoie(Date date_envoie) {
        this.date_envoie = date_envoie;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public StatusCourrier getStatut() {
        return statut;
    }

    public void setStatut(StatusCourrier statut) {
        this.statut = statut;
    }

    
    
}
