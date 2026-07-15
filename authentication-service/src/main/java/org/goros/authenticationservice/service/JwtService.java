package org.goros.authenticationservice.service;

import java.util.Map;

public interface JwtService {
    String generateToken(String username);
    String createToken(Map<String, Object> claims, String username);
}
