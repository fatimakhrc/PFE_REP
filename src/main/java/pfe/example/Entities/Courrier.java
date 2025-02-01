package pfe.example.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.sql.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;

@Entity
@Table (name = "courrier")
public class Courrier {
    @Id   // indique qu'il s'agit d'un identifiant
    @Column(name = "ID" , nullable = false) // definit des prop d'une champ dans une table ici c l'idetifiant
    private UUID id;
    @Column (name = "type_service")
    private String type_service ;
    @Column (name = "date_envoie")
    private Date date_envoie ;
    @Column (name = "poids")
    private double poids ;
    @Column (name = "statut")
    private String statut ;
    @Column (name = "cIN_dest")
    private String cIN_dest ;
    @Column (name = "cIN_expd")
    private String cIN_expd ;
    @Column (name = "trj_id")
    private String trj_id ;
    @Column (name = "etat_env")
    private String etat_env ;


    @ManyToOne
    @JoinColumn(name = "cIN_DEST", referencedColumnName = "CIN")
    private Client destinataire;

    @ManyToOne
    @JoinColumn(name = "cIN_EXP", referencedColumnName = "CIN")
    private Client expediteur;
    


    @ManyToOne
    @JoinColumn(name = "trj_id" , referencedColumnName = "trj_id")
    private Trajet trajetCourrier;


    @OneToOne
    @JoinColumn(name = "id")
    private Recus recus;

    public Courrier(UUID id, String type_service, Date date_envoie, double poids, String statut, String cIN_dest,
            String cIN_expd, String trj_id, String etat_env) {
        this.id = id;
        this.type_service = type_service;
        this.date_envoie = date_envoie;
        this.poids = poids;
        this.statut = statut;
        this.cIN_dest = cIN_dest;
        this.cIN_expd = cIN_expd;
        this.trj_id = trj_id;
        this.etat_env = etat_env;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType_service() {
        return type_service;
    }

    public void setType_service(String type_service) {
        this.type_service = type_service;
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCIN_dest() {
        return cIN_dest;
    }

    public void setCIN_dest(String cIN_dest) {
        this.cIN_dest = cIN_dest;
    }

    public String getCIN_expd() {
        return cIN_expd;
    }

    public void setCIN_expd(String cIN_expd) {
        this.cIN_expd = cIN_expd;
    }

    public String getTrj_id() {
        return trj_id;
    }

    public void setTrj_id(String trj_id) {
        this.trj_id = trj_id;
    }

    public String getEtat_env() {
        return etat_env;
    }

    public void setEtat_env(String etat_env) {
        this.etat_env = etat_env;
    }


    
}
