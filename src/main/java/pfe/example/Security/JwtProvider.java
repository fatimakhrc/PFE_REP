/* package pfe.example.Security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

@Component
public class JwtProvider {
    /*Classe `JwtProvider` pour générer et valider le JWT* :
Le *`JwtProvider`* est responsable de la génération et de la validation des tokens JWT
    @Value("app.jwt.secret")
    private String jwtSecret;
    @Value("{app.jwt.expiration}")
    private long jwtExpiration;

    // Generate JWT token
    public String generateJwtToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }// Get username from JWT token
    public String getUsernameFromJwtToken(String token) {
        // Use JwtParserBuilder to get the JwtParser
        JwtParser parser = Jwts.builder().setSigningKey(jwtSecret) // Set the secret key
        .build();

// Parse the JWT and return the username (subject)
return parser.parseClaimsJws(token)
        .getBody()
        .getSubject();}

        // Validate the JWT token
        public boolean validateJwtToken(String token) {
            try {
                // Use JwtParserBuilder to get the JwtParser
                JwtParser parser = Jwts.builder().setSigningKey(jwtSecret) // Set the secret key
                .build();

        // If the token is valid, it will be parsed successfully
        parser.parseClaimsJws(token);
        return true;} catch (JwtException | IllegalArgumentException e) {
            // If there is an error (invalid token, expired, etc.)
            return false;
        }
    }
} */