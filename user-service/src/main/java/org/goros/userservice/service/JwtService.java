package org.goros.userservice.service;

import io.jsonwebtoken.Claims;

public interface JwtService {
    Claims extractClaim(String token);
    boolean isValid(String token);
}
