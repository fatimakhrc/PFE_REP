package pfe.example.DTO;

public class VehiculeDto {
    private String immatriculation;
    private float capacite;
    private String type;

    
    public VehiculeDto() {
    }

    public VehiculeDto(String immatriculation, float capacite, String type) {
        this.immatriculation = immatriculation;
        this.capacite = capacite;
        this.type = type;
    }
    
    public String getImmatriculation() {
        return immatriculation;
    }
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    public float getCapacite() {
        return capacite;
    }
    public void setCapacite(float capacite) {
        this.capacite = capacite;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

}
