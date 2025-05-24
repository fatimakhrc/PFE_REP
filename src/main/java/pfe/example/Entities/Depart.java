/* package pfe.example.Entities;

import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Depart")
public class Depart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idDepart")
    private Long idDepart;

    @Column(name = "heure_dep")
    private LocalTime heure_dep;

    @Column(name = "heure_arrv")
    private LocalTime heure_arrv;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trj_id", referencedColumnName = "trj_id")
    private Trajet trajetDepart; 

    public Depart(Long idDepart, LocalTime heure_dep, LocalTime heure_arrv, Trajet trajetDepart) {
        this.idDepart = idDepart;
        this.heure_dep = heure_dep;
        this.heure_arrv = heure_arrv;
        this.trajetDepart = trajetDepart;
    }

    public Depart(){

    }

    public Long getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(Long idDepart) {
        this.idDepart = idDepart;
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

    public Trajet getTrajetDepart() {
        return trajetDepart;
    }

    public void setTrajetDepart(Trajet trajetDepart) {
        this.trajetDepart = trajetDepart;
    }
} */