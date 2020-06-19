package com.sallu.api.services.jwt;

import com.sallu.api.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    public String token(User userModel) {

        long stringToLong = Long.parseLong(this.expiration);

        LocalDateTime expirationHour = LocalDateTime.now().plusHours(stringToLong);

        Instant localDateTime = expirationHour.atZone(ZoneId.systemDefault()).toInstant();

        Date expirationDateTime = Date.from(localDateTime);

        return Jwts.builder()
                .setSubject(userModel.getEmail()) // userModel.getName()
                .setExpiration(expirationDateTime)
                .signWith(SignatureAlgorithm.HS256, this.secret)
                .compact();
    }

    Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts.parser()
                .setSigningKey(this.secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenValid(String token) {
        try {
            Claims claims = getClaims(token);

            Date expiration = claims.getExpiration();

            LocalDateTime expirationDateTime = expiration.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            return !LocalDateTime.now().isAfter(expirationDateTime);
        } catch (Exception err) {
            return false;
        }
    }

    public String getUserLogin(String token) throws ExpiredJwtException {
        return getClaims(token).getSubject();
    }
}
