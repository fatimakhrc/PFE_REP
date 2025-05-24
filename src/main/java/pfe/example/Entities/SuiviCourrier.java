/* package pfe.example.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="SuiviCourrier ")
public class SuiviCourrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_suivi;

    private double latitude;
    private double longitude;
    private LocalDateTime dateSuivi;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Courrier courrier;

    public SuiviCourrier() {
    }

    public SuiviCourrier(Long id_suivi, double latitude, double longitude, LocalDateTime dateSuivi, Courrier courrier) {
        this.id_suivi = id_suivi;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateSuivi = dateSuivi;
        this.courrier = courrier;
    }

    public Long getIdSuivi() {
        return id_suivi;
    }

    public void setId_suivi(Long id_suivi) {
        this.id_suivi = id_suivi;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getDateSuivi() {
        return dateSuivi;
    }

    public void setDateSuivi(LocalDateTime dateSuivi) {
        this.dateSuivi = dateSuivi;
    }

    public Courrier getCourrier() {
        return courrier;
    }

    public void setCourrier(Courrier courrier) {
        this.courrier = courrier;
    }

}
 */