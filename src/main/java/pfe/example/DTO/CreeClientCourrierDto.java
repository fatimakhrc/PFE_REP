package pfe.example.DTO;

import java.time.LocalDate;

import pfe.example.Entities.StatusCourrier;

public class CreeClientCourrierDto {
    private String cin;
    private String nom_clt;
    private String prenom_clt;
    private String clt_adress;
    private String phone_number;
    private Long id;
    private LocalDate dateEnvoie;
    private double poids;
    private StatusCourrier statut;
    private double prixTransmission;
    private String cin_dest;
    private String nom_complet_dest;
    private String adresse_dest;
    private String agenceExped;
    private String agenceDest;
    

    public CreeClientCourrierDto() {
    }

    public CreeClientCourrierDto(String cin, String nom_clt, String prenom_clt, String clt_adress, String phone_number,
            Long id, LocalDate dateEnvoie, double poids, StatusCourrier statut, double prixTransmission,
            String cin_dest, String nom_complet_dest, String adresse_dest, String agenceExped, String agenceDest) {
        this.cin = cin;
        this.nom_clt = nom_clt;
        this.prenom_clt = prenom_clt;
        this.clt_adress = clt_adress;
        this.phone_number = phone_number;
        this.id = id;
        this.dateEnvoie = dateEnvoie;
        this.poids = poids;
        this.statut = statut;
        this.prixTransmission = prixTransmission;
        this.cin_dest = cin_dest;
        this.nom_complet_dest = nom_complet_dest;
        this.adresse_dest = adresse_dest;
        this.agenceExped = agenceExped;
        this.agenceDest = agenceDest;
    }
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
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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
    public String getCin_dest() {
        return cin_dest;
    }
    public void setCin_dest(String cin_dest) {
        this.cin_dest = cin_dest;
    }
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
    public String getAgenceExped() {
        return agenceExped;
    }
    public void setAgenceExped(String agenceExped) {
        this.agenceExped = agenceExped;
    }
    public String getAgenceDest() {
        return agenceDest;
    }
    public void setAgenceDest(String agenceDest) {
        this.agenceDest = agenceDest;
    }
   

}
