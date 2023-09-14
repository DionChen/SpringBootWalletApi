package com.backend.wallet.config.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthTokenService {

    @Value("${security.jwt.jwtSecret}")
    private String jwtSecret;
    @Value("${security.jwt.jwtExpirationMs}")
    private int jwtExpirationMs;


    public void generate() {

    }

    public String getSubjectByJwt(String jwt) {
        return Jwts
                .parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .build()
                .parseClaimsJwt(jwt)
                .getBody()
                .getSubject();
    }
}
