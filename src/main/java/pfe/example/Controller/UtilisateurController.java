package pfe.example.Controller;

import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import pfe.example.DTO.LoginRequest;
import pfe.example.Entities.Utilisateur;
import pfe.example.Services.RoleService;
import pfe.example.Services.UtilisateurService;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {
    @Autowired 
    private UtilisateurService utilisateurService;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Value("${jwt.secret}")
    private String secretKey;

    @Autowired 
    private RoleService roleService;
    //METHODE DE L'AUTHENTIFICATION
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Authentifie l'utilisateur avec Spring Security
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getMot_passe())
            );

            // Récupère le rôle à partir des autorités
            String role = authentication.getAuthorities().iterator().next().getAuthority();

            // Crée le JWT
            String token = Jwts.builder()
                    .setSubject(loginRequest.getEmail())
                    .claim("role", role)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Token valide 24h
                    .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey)))
                    .compact();

            return ResponseEntity.ok(Collections.singletonMap("token", token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mot de passe incorrect.");
        }
    }
   /*  @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Utilisateur utilisateur = utilisateurService.login(loginRequest.getEmail(), loginRequest.getMot_passe());
        if (utilisateur != null) {
            //verification de role
            String roleName = utilisateur.getRole().getNom();  

            if ("Admin".equals(roleName)) {
                return ResponseEntity.ok("Welcome Admin! You can access admin features.");
            } else if ("Opérateur".equals(roleName)) {
                return ResponseEntity.ok("Welcome Operator! You can access operator features.");
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Role not authorized.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
        }
    } */

    @GetMapping ("/{email}")
    public ResponseEntity<Utilisateur> getUtilisateurByEmail(@PathVariable String email){
        Utilisateur utilisateur = utilisateurService.getUtilisateurByEmail(email);
        if (utilisateur != null){
            return ResponseEntity.ok(utilisateur);
        }
        return ResponseEntity.notFound().build();
        //retourne un erreur 404 si l'utilisateur n'est pas trouve 
    }
    //creer un nouveau utilisateur 
    @PostMapping 
    public ResponseEntity<Utilisateur> createUtilisateur (@RequestBody Utilisateur utilisateur){
        Utilisateur createdUtilisateur = utilisateurService.createUtilisateur(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUtilisateur);
    }
    //mise a jour de l'utilisateur 
    @PutMapping("/update/{email}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable String email, @RequestBody Utilisateur utilisateur) {
        Utilisateur updatedUtilisateur = utilisateurService.updateUtilisateur(email, utilisateur);
        if (updatedUtilisateur != null) {
            return ResponseEntity.ok(updatedUtilisateur);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    //supprimer un utilisateur
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable String email) {
        boolean isDeleted = utilisateurService.deleteUtilisateur(email);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    
}
