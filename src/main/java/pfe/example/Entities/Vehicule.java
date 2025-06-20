package pfe.example.Entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vehicule")
public class Vehicule {
    @Id
    @Column (name = "immatriculation" , nullable = false )
    private String immatriculation;
    @Column (name = "capacite")
    private int capacite ;
    @Column (name = "type")
    private String type ;


    public Vehicule(String immatriculation, int capacite, String type) {
        this.immatriculation = immatriculation;
        this.capacite = capacite;
        this.type = type;
    }

    public Vehicule (){

    }

    

    /*@ManyToOne
    @JoinColumn (name = "trj_id" , referencedColumnName = "trj_id" ,insertable = false, updatable = false)
    private Trajet trajetVehicule;*/

    @OneToOne(mappedBy = "vehiculeTransporteur")
    private Transporteur transporteurVehicule;

    @ManyToOne
    @JoinColumn(name = "id_agence")
    private Agence agenceVehicule;

    
    public String getImtrc() {
        return immatriculation;
    }
    public void setImtrc(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    public int getCapacite() {
        return capacite;
    }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    /*public Trajet getTrajetVehicule() {
        return trajetVehicule;
    }
    public void setTrajetVehicule(Trajet trajetVehicule) {
        this.trajetVehicule = trajetVehicule;
    }*/
    public Transporteur getTransporteurVehicule() {
        return transporteurVehicule;
    }
    public void setTransporteurVehicule(Transporteur transporteurVehicule) {
        this.transporteurVehicule = transporteurVehicule;
    }

    public Agence getAgenceVehicule() {
    return agenceVehicule;
    }

    public void setAgenceVehicule(Agence agenceVehicule) {
        this.agenceVehicule = agenceVehicule;
    }


    


    
}
