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
    @Column (name = "agenceExped")
    private String agenceExped;
    @Column (name = "agenceDest")
    private String agenceDest;
    //ajouter les infos dyal destinataire
    @Column (name = "nom_complet_dest")
    private String nom_complet_dest;
    @Column (name = "adresse_dest")
    private String adresse_dest;
    

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cin_dest", referencedColumnName = "CIN" )
    private Client clientDest;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cIN_EXP", referencedColumnName = "CIN")
    private Client clientExped;
    

    /* @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "trj_id" , referencedColumnName = "trj_id")
    private Trajet trajetCourrier;
 */


    public Courrier(Long id, LocalDate dateEnvoie, double poids, StatusCourrier statut, double prixTransmission,
             String nom_complet_dest, String adresse_dest, Client clientDest, Client clientExped,
            String agenceDest, String agenceExped) {
        this.id = id;
        this.dateEnvoie = dateEnvoie;
        this.poids = poids;
        this.statut = statut;
        this.prixTransmission = prixTransmission;
        
        this.nom_complet_dest = nom_complet_dest;
        this.adresse_dest = adresse_dest;
        this.clientDest = clientDest;
        this.clientExped = clientExped;
        this.agenceDest = agenceDest;
        this.agenceExped = agenceExped;
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

    public StatusCourrier getStatut() {
        return statut;
    }

    public void setStatut(StatusCourrier statut) {
        this.statut = statut;
    }

    public double getPrixTransmission() {
        return prixTransmission;
    }

    public void setPrixTransmission(double prixTransmission) {
        this.prixTransmission = prixTransmission;
    }

    /* public String getCin_dest() {
        return cin_dest;
    }

    public void setCin_dest(String cin_dest) {
        this.cin_dest = cin_dest;
    }
 */
    public String getNom_complet_dest() {
        return nom_complet_dest;
    }

    public void setNom_complet_dest(String nom_complet_dest) {
        this.nom_complet_dest = nom_complet_dest;
    }

    public String getAdresse_dest() {
        return adresse_dest;
    }

    public void setAdresse_dest(String adresse_dest) {
        this.adresse_dest = adresse_dest;
    }

    public Client getClientDest() {
        return clientDest;
    }

    public void setClientDest(Client clientDest) {
        this.clientDest = clientDest;
    }

    public Client getClientExped() {
        return clientExped;
    }

    public void setClientExped(Client clientExped) {
        this.clientExped = clientExped;
    }

    /* public Trajet getTrajetCourrier() {
        return trajetCourrier;
    }

    public void setTrajetCourrier(Trajet trajetCourrier) {
        this.trajetCourrier = trajetCourrier;
    } */

    public String getAgenceDest() {
        return agenceDest;
    }

    public void setAgenceDest(String agenceDest) {
        this.agenceDest = agenceDest;
    }

    public String getAgenceExped() {
        return agenceExped;
    }

    public void setAgenceExped(String agenceExped) {
        this.agenceExped = agenceExped;
    }
    

}