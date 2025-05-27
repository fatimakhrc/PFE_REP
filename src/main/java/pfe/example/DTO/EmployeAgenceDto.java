package pfe.example.DTO;

public class EmployeAgenceDto {
    private String cin;
    private String nom;
    private String prenom;
    private String adresse;
    private String email; // rempli si opérateur
    private String mot_passe; // rempli si opérateur
    private String emp_phone;


    public EmployeAgenceDto(String cin, String nom, String prenom, String adresse, String email, String mot_passe , String emp_phone) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.mot_passe = mot_passe;
        this.emp_phone = emp_phone;
    }


    public EmployeAgenceDto() {
    }


    public String getCin() {
        return cin;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
    public String getEmp_phone() {
        return emp_phone;
    }
    public void setEmp_phone(String emp_phone) {
        this.emp_phone = emp_phone;
    }

    
}