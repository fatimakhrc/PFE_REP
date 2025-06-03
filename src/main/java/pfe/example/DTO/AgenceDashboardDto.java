package pfe.example.DTO;

import pfe.example.Entities.Agence;

public class AgenceDashboardDto {
    private Long id;
    private String nom;
    private String adresse;
    private int nombreEmployes;
    private int nombreVehicules;

    public AgenceDashboardDto(Agence agence) {
        this.id = agence.getId_agence();
        this.nom = agence.getNomAgence();
        this.adresse = agence.getAdresse_agence();
        //
        this.nombreEmployes = agence.getEmployes() != null ? agence.getEmployes().size() : 0;
        this.nombreVehicules = agence.getTransporteurs() != null
            ? agence.getTransporteurs()
            .stream()
            .mapToInt(t -> t.getVehiculeTransporteur() != null ? 1 : 0)
            .sum()
            : 0;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNombreEmployes() {
        return nombreEmployes;
    }

    public void setNombreEmployes(int nombreEmployes) {
        this.nombreEmployes = nombreEmployes;
    }

    public int getNombreVehicules() {
        return nombreVehicules;
    }

    public void setNombreVehicules(int nombreVehicules) {
        this.nombreVehicules = nombreVehicules;
    }
    
    
}