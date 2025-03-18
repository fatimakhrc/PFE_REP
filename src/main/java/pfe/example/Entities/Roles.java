package pfe.example.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_role;
    @Column (name = "nom")//il va etre soit operateur soit administrateur
    private String nom;
    
    public Roles() {
    }

    public Roles(long id_role, String nom) {
        this.id_role = id_role;
        this.nom = nom;
    }


    public long getId_role() {
        return id_role;
    }
    public void setId_role(long id_role) {
        this.id_role = id_role;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }
    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
    
    @ManyToMany
    @JoinTable(name="droits_roles",joinColumns=@JoinColumn(name="id_role"),inverseJoinColumns=@JoinColumn(name="id_droits"))
    private List <Droits> droits;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL) /*  on utilise cascade pour dire que chaque
          modification faite sur l'un des entites parent sera faite a tous les autres */
    private List<Utilisateur> utilisateurs;
}
