package pfe.example.DTO;

import java.util.function.LongBinaryOperator;

import pfe.example.Entities.Employe;

public class EmployeDashboardDto {
    private String empCin;
    private String nom_emp;
    private String prenom_emp;
    private String empAdresse;
    private String empPhone;
    private Long idAgence;
    private String role;
    private String email;
    private String mot_passe; //mot de passe en clair uniquement pour retour
    private String immatriculation;

    public EmployeDashboardDto(Employe employe, String role, String motDePasseClair) {
        this.empCin = employe.getEmpCin();
        this.nom_emp = employe.getNom_emp();
        this.prenom_emp = employe.getPrenom_emp();
        this.empAdresse = employe.getEmp_adresse();
        this.empPhone = employe.getEmp_phone();
        this.idAgence = employe.getAgence().getId_agence();
        this.role = role;

        if ("OPERATEUR".equalsIgnoreCase(role)) {
            this.email = employe.getUtilisateur().getEmail();
            this.mot_passe = motDePasseClair; // Affiché en clair
            this.immatriculation = "-";
        } else if ("TRANSPORTEUR".equalsIgnoreCase(role)) {
            this.email = "-";
            this.mot_passe = "-";
            this.immatriculation = employe.getTransporteur().getVehiculeTransporteur().getImtrc();
        }
    }

    public String getEmpCin() {
        return empCin;
    }

    public void setEmpCin(String empCin) {
        this.empCin = empCin;
    }

    public String getNom_emp() {
        return nom_emp;
    }

    public void setNom_emp(String nom_emp) {
        this.nom_emp = nom_emp;
    }

    public String getPrenom_emp() {
        return prenom_emp;
    }

    public void setPrenom_emp(String prenom_emp) {
        this.prenom_emp = prenom_emp;
    }

    public String getEmpAdresse() {
        return empAdresse;
    }

    public void setEmpAdresse(String empAdresse) {
        this.empAdresse = empAdresse;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public Long getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(Long idAgence) {
        this.idAgence = idAgence;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMot_passe() {
        return mot_passe;
    }

    public void setMot_passe(String mot_passe) {
        this.mot_passe = mot_passe;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    
}
