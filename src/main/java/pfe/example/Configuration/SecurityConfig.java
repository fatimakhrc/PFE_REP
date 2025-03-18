package pfe.example.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pfe.example.Services.UtilisateurService;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    /* @Autowired
    //private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/api/auth/**").permitAll()  // Autoriser certaines routes sans authentification
        .antMatchers("/api/admin/**").hasRole("ADMINISTRATEUR")  // Restreindre les routes aux admins
        .antMatchers("/api/operator/**").hasRole("OPERATORATEUR")  // Restreindre les routes aux opérateurs
        .anyRequest().authenticated()  // Autres routes nécessitant une authentification
            .and()
            .formLogin().permitAll()  // Autoriser le formulaire de login par défaut
            .and().httpBasic();  // Activer HTTP Basic Authentication
        }
     */
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    
       /*  @Override
        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    } */




}
