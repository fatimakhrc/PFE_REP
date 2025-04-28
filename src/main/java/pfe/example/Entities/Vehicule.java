package pfe.example.Entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vehicule")
public class Vehicule {
    @Id
    @Column (name = "immatriculation" , nullable = false )
    private String imtrc;
    @Column (name = "capacite")
    private float capacite ;
    @Column (name = "type")
    private String type ;
    @Column (name = "trj_id")
    private String trajetId ;
    @Column (name = "trs_cin")
    private String trs_cin;


    public Vehicule(String imtrc, float capacite, String type, String trajetId,String trs_cin) {
        this.imtrc = imtrc;
        this.capacite = capacite;
        this.type = type;
        this.trajetId = trajetId;
        this.trs_cin = trs_cin;
    }

    
    @ManyToOne
    @JoinColumn (name = "trj_id" , referencedColumnName = "trj_id" ,insertable = false, updatable = false)
    private Trajet trajetVehicule;

    @ManyToOne 
    @JoinColumn (name = "trs_CIN" , referencedColumnName = "trs_CIN", insertable = false, updatable = false)
    private Transporteur transporteurVehicule;

    
    public String getImtrc() {
        return imtrc;
    }
    public void setImtrc(String imtrc) {
        this.imtrc = imtrc;
    }
    public float getCapacite() {
        return capacite;
    }
    public void setCapacite(float capacite) {
        this.capacite = capacite;
    }
    public String getTrajetId() {
        return trajetId;
    }
    public void setTrajetId(String trajetId) {
        this.trajetId = trajetId;
    }
    public String getTrs_cin() {
        return trs_cin;
    }
    public void setTrs_cin(String trs_cin) {
        this.trs_cin = trs_cin;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Trajet getTrajetVehicule() {
        return trajetVehicule;
    }
    public void setTrajetVehicule(Trajet trajetVehicule) {
        this.trajetVehicule = trajetVehicule;
    }
    public Transporteur getTransporteurVehicule() {
        return transporteurVehicule;
    }
    public void setTransporteurVehicule(Transporteur transporteurVehicule) {
        this.transporteurVehicule = transporteurVehicule;
    }


    


    
}
