package com.example.crudfix.util;

import com.example.crudfix.config.JwtConfiguration;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtBuilder {
    private JwtConfiguration jwtConfig;

    public JwtBuilder(JwtConfiguration jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public String Build(String userId) {

        String secretKey = jwtConfig.getSecret();
        int expiration = jwtConfig.getExpiration();

        Claims claims = Jwts.claims();
        claims.setSubject(userId);
        claims.setIssuer("Lim");
        claims.setExpiration(new Date(System.currentTimeMillis() + expiration * 1000));
        claims.setIssuedAt(new Date());

        String jwt = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return jwt;
    }

}
