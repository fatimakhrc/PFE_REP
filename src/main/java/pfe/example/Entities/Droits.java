package pfe.example.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "droits")
public class Droits {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id_droit;
    private String nomDroit;

    @ManyToMany(mappedBy = "droits",cascade = CascadeType.ALL)
    private List<Roles> roles ;


    public Droits() {
    }


    public Droits(long id_droit, String nomDroit) {
        this.id_droit = id_droit;
        this.nomDroit = nomDroit;
    }

    
    public long getId_droit() {
        return id_droit;
    }

    public void setId_droit(long id_droit) {
        this.id_droit = id_droit;
    }

    public String getNomDroit() {
        return nomDroit;
    }

    public void setNomDroit(String nomDroit) {
        this.nomDroit = nomDroit;
    }

  

    
}