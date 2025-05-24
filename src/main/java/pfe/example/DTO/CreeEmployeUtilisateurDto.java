package pfe.example.DTO;

public class CreeEmployeUtilisateurDto {
    private String emp_cin;
    private String nom_emp;
    private String prenom_emp;
    private String id_agence;

    private String email;
    private String mot_passe;
    private String role;

    public CreeEmployeUtilisateurDto(String emp_cin, String nom_emp, String prenom_emp, String id_agence, String email,
            String mot_passe, String role) {
        this.emp_cin = emp_cin;
        this.nom_emp = nom_emp;
        this.prenom_emp = prenom_emp;
        this.id_agence = id_agence;
        this.email = email;
        this.mot_passe = mot_passe;
        this.role = role;
    }


    public CreeEmployeUtilisateurDto() {
}


    public String getEmp_cin() {
        return emp_cin;
 }
    public void setEmp_cin(String emp_cin) {
        this.emp_cin = emp_cin;
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
    public String getId_agence() {
        return id_agence;
    }
    public void setId_agence(String id_agence) {
        this.id_agence = id_agence;
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
 