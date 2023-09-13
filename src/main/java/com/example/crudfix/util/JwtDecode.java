package com.example.crudfix.util;

import com.example.crudfix.config.JwtConfiguration;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class JwtDecode {

    private JwtConfiguration jwtConfig;

    public JwtDecode(JwtConfiguration jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public String Decode(String token) {
        String secretKey = jwtConfig.getSecret();

        Jws<Claims> jwtClaims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);

        Claims claims = jwtClaims.getBody();

        String userId = claims.getSubject();

        return userId;
    }
}
