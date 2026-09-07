package org.goros.categoryservice.service;

import io.jsonwebtoken.Claims;

public interface JwtService {
    Claims extractClaims(String token);
    boolean isValidKey(String token);
}
