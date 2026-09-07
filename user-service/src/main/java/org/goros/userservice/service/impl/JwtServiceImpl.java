package org.goros.userservice.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.goros.userservice.service.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtServiceImpl implements JwtService {
    @Value("${jwt.secret}")
    public String secret;

    @Override
    public Claims extractClaim(String token) {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        SecretKey keys = Keys.hmacShaKeyFor(keyBytes);
        return Jwts.parser().verifyWith(keys).build().parseSignedClaims(token).getPayload();
    }

    @Override
    public boolean isValid(String token) {
        try {
            extractClaim(token);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
