package pfe.example.DTO;

public class LoginRequest {
    //loginRequest est un dto data transmissionobjrct qui permet de recuperer les informations necessere pour le login 
    private String email ;
    private String mot_passe;
    private String role;// role selectionne par l'utilisateur (admin ou operateur )

    public LoginRequest() {
    }

    public LoginRequest(String email, String mot_passe) {
        this.email = email;
        this.mot_passe = mot_passe;
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
