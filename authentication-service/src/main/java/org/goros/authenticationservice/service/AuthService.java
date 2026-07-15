package org.goros.authenticationservice.service;

public interface AuthService {
    String generateToken(String username);
    void validateToken(String token);
}
