package org.goros.authenticationservice.service;

import org.goros.authenticationservice.config.CustomUserDetails;

import java.util.Date;

public interface AuthService {
    String generateToken(String username);
    void validateToken(String token, CustomUserDetails userDetails);
    Date getExpiryDate(String token);
}
