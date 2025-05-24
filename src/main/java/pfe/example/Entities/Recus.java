/* package pfe.example.Entities;

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
    private Courrier courrierRecus;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id_agence")
    private Agence agenceRecus;

    @Column(name = "date_livraison")
    private Date date_livraison;

    public Recus() {}

    public Recus(Courrier courrierRecus, Agence agenceRecus, Date date_livraison) {
        this.courrierRecus = courrierRecus;
        this.agenceRecus = agenceRecus;
        this.date_livraison = date_livraison;
    }

    public Courrier getCourreirRecus() {
        return courrierRecus;
    }

    public void setCourreirRecus(Courrier courrrRecus) {
        this.courrierRecus = courrierRecus;
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





 */