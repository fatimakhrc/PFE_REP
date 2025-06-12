package pfe.example.DTO;

import pfe.example.Entities.Vehicule;

public class VehiculeDashboardDto {

    private String immatriculation;
    private String type;
    private int capacite;
    private String nomAgence;

    public VehiculeDashboardDto() {}

    public VehiculeDashboardDto(Vehicule vehicule) {
        this.immatriculation = vehicule.getImtrc();
        this.type = vehicule.getType();
        this.capacite = vehicule.getCapacite();

        if (vehicule.getAgenceVehicule() != null) {
            this.nomAgence = vehicule.getAgenceVehicule().getNomAgence();
        } else {
            this.nomAgence = "-";
        }
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }
    

}
