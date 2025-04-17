package pfe.example.Entities;

import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Depart")
public class Depart {
    @Id
    @Column (name = "trj_id")  // vous pouver ajouter apres generatd value
    private String trj_id ;
    @Column(name = "heure_dep")
    private LocalTime heure_dep ;
    @Column (name = "heure_arrv")
    private LocalTime heure_arrv ;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn( name = "trj_id" , referencedColumnName = "trj_id")
    private Trajet trajetDepart ;


    public Depart(String trj_id, LocalTime heure_dep, LocalTime heure_arrv) {
        this.trj_id = trj_id;
        this.heure_dep = heure_dep;
        this.heure_arrv = heure_arrv;
    }

    public String getTrj_id() {
        return trj_id;
    }
    public void setTrj_id(String trj_id) {
        this.trj_id = trj_id;
    }
    public LocalTime getHeure_dep() {
        return heure_dep;
    }
    public void setHeure_dep(LocalTime heure_dep) {
        this.heure_dep = heure_dep;
    }
    public LocalTime getHeure_arrv() {
        return heure_arrv;
    }
    public void setHeure_arrv(LocalTime heure_arrv) {
        this.heure_arrv = heure_arrv;
    }
  
    
}
