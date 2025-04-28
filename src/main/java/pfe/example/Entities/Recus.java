package pfe.example.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Recus")
@IdClass(RecusId.class)
public class Recus {
   
    @Id
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Courrier courreirRecus;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id_agence")
    private Agence agenceRecus;

    @Column(name = "date_livraison")
    private Date date_livraison;

    public Recus() {}

    public Recus(Courrier courreirRecus, Agence agenceRecus, Date date_livraison) {
        this.courreirRecus = courreirRecus;
        this.agenceRecus = agenceRecus;
        this.date_livraison = date_livraison;
    }

    public Courrier getCourreirRecus() {
        return courreirRecus;
    }

    public void setCourreirRecus(Courrier courreirRecus) {
        this.courreirRecus = courreirRecus;
    }

    public Agence getAgenceRecus() {
        return agenceRecus;
    }

    public void setAgenceRecus(Agence agenceRecus) {
        this.agenceRecus = agenceRecus;
    }

    public Date getDate_livraison() {
        return date_livraison;
    }

    public void setDate_livraison(Date date_livraison) {
        this.date_livraison = date_livraison;
    }
}





