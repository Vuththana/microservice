package org.goros.authenticationservice.service;

import org.goros.authenticationservice.config.CustomUserDetails;

import java.util.Date;
import java.util.Map;

public interface JwtService {
    String generateToken(String username);
    String createToken(Map<String, Object> claims, String username);
    Date extractExpirationDate(String token);
    boolean validateToken(String token, CustomUserDetails userDetails);
}
