package pfe.example.DTO;

public class CreeEmployeUtilisateurDto {
    private String empCin;
    private String nom_emp;
    private String prenom_emp;
    private Long id_agence;
    private String emp_phone;
    private String emp_adresse;
    private String immatriculation;
    private String email;
    private String mot_passe;
    private String role;


    public CreeEmployeUtilisateurDto(String empCin, String nom_emp, String prenom_emp, Long id_agence,
            String emp_phone, String emp_adresse, String immatriculation, String email, String mot_passe, String role) {
        this.empCin = empCin;
        this.nom_emp = nom_emp;
        this.prenom_emp = prenom_emp;
        this.id_agence = id_agence;
        this.emp_phone = emp_phone;
        this.emp_adresse = emp_adresse;
        this.immatriculation = immatriculation;
        this.email = email;
        this.mot_passe = mot_passe;
        this.role = role;
    }


    public CreeEmployeUtilisateurDto() {
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
    public Long getId_agence() {
        return id_agence;
    }
    public void setId_agence(Long id_agence) {
        this.id_agence = id_agence;
    }
    public String getEmp_phone() {
        return emp_phone;
    }
    public void setEmp_phone(String emp_phone) {
        this.emp_phone = emp_phone;
    }
    public String getEmp_adresse() {
        return emp_adresse;
    }
    public void setEmp_adresse(String emp_adresse) {
        this.emp_adresse = emp_adresse;
    }
    public String getImmatriculation() {
        return immatriculation;
    }
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
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
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

}
 