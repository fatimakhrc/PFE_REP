package pfe.example.Security;



import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import pfe.example.DAO.UtilisateurRep;
import pfe.example.Entities.Utilisateur;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UtilisateurRep utilisateurRep;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Rechercher l'utilisateur dans la base de donnees 
        Utilisateur utilisateur = utilisateurRep.findByEmail(email);
        if (utilisateur == null || !passwordEncoder.matches(password, utilisateur.getMot_passe())) {
            throw new AuthenticationException("Email ou mot de passe incorrect") {};
        }

        // Retourner un token d'authentification valide avec le rôle de l'utilisateur
        return new UsernamePasswordAuthenticationToken(
            email, null,
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + utilisateur.getRole().getNom().toUpperCase()))
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
