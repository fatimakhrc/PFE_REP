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
    @Column (name = "trj_id")
    private String trj_id ;
    @Column (name = "trs_CIN")
    private String trs_CIN ;


    public Vehicule(String imtrc, float capacite, String trj_id,String trs_CIN) {
        this.imtrc = imtrc;
        this.capacite = capacite;
        this.trj_id = trj_id;
        this.trs_CIN = trs_CIN;
    }

    
    @ManyToOne
    @JoinColumn (name = "trj_id" , referencedColumnName = "trj_id")
    private Trajet trajetVehicule;

    @ManyToOne 
    @JoinColumn (name = "trs_CIN" , referencedColumnName = "trs_CIN")
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
    public String getTrj_id() {
        return trj_id;
    }
    public void setTrj_id(String trj_id) {
        this.trj_id = trj_id;
    }
    public String getTrs_CIN() {
        return trs_CIN;
    }
    public void setTrs_CIN(String trs_CIN) {
        this.trs_CIN = trs_CIN;
    }


    


    
}
