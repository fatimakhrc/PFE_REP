package pfe.example.Entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Recus")
public class Recus {
    @Id 
    @Column (name = "id" , nullable = false )
    private UUID id ;
    @Id
    @Column (name = "id_agence" , nullable = false)
    private String id_agence ;
    @Column (name = "date_livraison")
    private Date date_livraison ;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_agence" , referencedColumnName = "id_agence")
    private Agence agenceRecus;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id" , referencedColumnName = "id")
    private Courrier courreirRecus;

    
    public Recus(UUID id, String id_agence, Date date_livraison) {
        this.id = id;
        this.id_agence = id_agence;
        this.date_livraison = date_livraison;
    }


    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getId_agence() {
        return id_agence;
    }
    public void setId_agence(String id_agence) {
        this.id_agence = id_agence;
    }
    public Date getDate_livraison() {
        return date_livraison;
    }
    public void setDate_livraison(Date date_livraison) {
        this.date_livraison = date_livraison;
    }


    
    
    
}
