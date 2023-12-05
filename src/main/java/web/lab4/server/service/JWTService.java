package web.lab4.server.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.ejb.Stateless;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Stateless
public class JWTService {
    private static final String SECRET_KEY = "pancakes";

    public String createToken(String username) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        Instant now = Instant.now();
        Instant expiryDate = now.plus(1, ChronoUnit.WEEKS);

        return Jwts.builder()
                .subject(username)
                .issuedAt(Date.from(now))
                .expiration(Date.from(expiryDate))
                .signWith(key)
                .compact();
    }

    public String validateAndExtractUsername(String token) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        try {
            Jws<Claims> claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
            return claims.getPayload().getSubject();
        } catch (Exception e) {
            return null;
        }
    }
}
