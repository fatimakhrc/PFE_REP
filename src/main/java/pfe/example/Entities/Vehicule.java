package pfe.example.Entities;

import java.time.Duration;

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
    @Column (name = "duree_transport")
    private Duration duree_transport;
    @Column (name = "nature_transport")
    private String nature_transport ;
    @Column (name = "capacite")
    private float capacite ;
    @Column (name = "trj_id")
    private String trj_id ;
    @Column (name = "trs_CIN")
    private String trs_CIN ;


    public Vehicule(String imtrc, Duration duree_transport, String nature_transport, float capacite, String trj_id,
            String trs_CIN) {
        this.imtrc = imtrc;
        this.duree_transport = duree_transport;
        this.nature_transport = nature_transport;
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
    public Duration getDuree_transport() {
        return duree_transport;
    }
    public void setDuree_transport(Duration duree_transport) {
        this.duree_transport = duree_transport;
    }
    public String getNature_transport() {
        return nature_transport;
    }
    public void setNature_transport(String nature_transport) {
        this.nature_transport = nature_transport;
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
