package pfe.example.Configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import pfe.example.Security.CustomAuthenticationProvider;
import pfe.example.Security.JwtFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity  
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;
    
    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .cors(withDefaults())  //  Utilisation correcte
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/utilisateur/login").permitAll()
                .requestMatchers("/api/utilisateur/**").permitAll()
                .requestMatchers("/api/agence/**").hasRole("ADMIN")
                .requestMatchers("/api/vehicule/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .authenticationProvider(customAuthenticationProvider)
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}