/*  package pfe.example.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pfe.example.DAO.UtilisateurRep;
import pfe.example.Entities.Utilisateur;

public class CustomUtilisateruDetailService implements UserDetailsService{
    /*cette class est une service qui implemet l'interface predefinis dans spring security il va permet
     * de recuperer les infos d'un utilisateur pour l'authentification et l'autorisation .
    
    @Autowired 
    private UtilisateurRep utilisateurRep;
    @Override 
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //chercher l'utilisateur dans la base de donnees par son email 
        Utilisateur utilisateur = utilisateurRep.findByEmail(email);
        if (utilisateur == null){
            throw new UsernameNotFoundException("utiliisateur n'est pas trouve avec cet email : " +email);

        }
         // Retourner un objet User (Spring Security) avec les informations nécessaires
         // Ici, on suppose que l'utilisateur a un seul rôle et que le mot de passe est haché
        return new User(
            utilisateur.getEmail(),
            utilisateur.getMot_passe(),  // Mot de passe haché
            AuthorityUtils.createAuthorityList(utilisateur.getRole().getNom())  // Rôle de l'utilisateur
        );
    }

}
 */