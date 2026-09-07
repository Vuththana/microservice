package org.goros.categoryservice.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.goros.categoryservice.service.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    public String secret;

    @Override
    public Claims extractClaims(String token) {
        byte[] keys  = Decoders.BASE64.decode(secret);
        SecretKey scKeys = Keys.hmacShaKeyFor(keys);
        return Jwts.parser().verifyWith(scKeys).build().parseSignedClaims(token).getPayload();
    }

    @Override
    public boolean isValidKey(String token) {
        try {
            extractClaims(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
