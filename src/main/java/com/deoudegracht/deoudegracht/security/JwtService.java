package com.deoudegracht.deoudegracht.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtService {
    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);
    // Base64 encoded secret key
    private final static String SECRET_KEY = "eWFiYmFkYWJiYWRvb3lhYmJhZGFiYmFkb295YWJiYWRhYmJhZG9veWFiYmFkYWJiYWRvbw==";

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        // Add roles to claims
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        if (!authorities.isEmpty()) {
            List<String> roles = authorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .toList();
            claims.put("roles", roles);
            logger.debug("Adding roles to token: {}", roles);
        }
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        long validPeriod = 1000 * 60 * 60 * 24 * 10; // 10 days in ms
        Date now = new Date();
        Date validity = new Date(now.getTime() + validPeriod);
        
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        try {
            final String username = extractUsername(token);
            Claims claims = extractAllClaims(token);
            logger.debug("Token claims for user {}: {}", username, claims);
            
            boolean isValid = (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
            logger.debug("Token validation result for user {}: {}", username, isValid);
            
            return isValid;
        } catch (Exception e) {
            logger.error("Error validating token: ", e);
            return false;
        }
    }
}
