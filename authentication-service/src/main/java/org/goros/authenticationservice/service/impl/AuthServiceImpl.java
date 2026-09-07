package org.goros.authenticationservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.goros.authenticationservice.config.CustomUserDetails;
import org.goros.authenticationservice.service.AuthService;
import org.goros.authenticationservice.service.JwtService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    public final JwtService jwtService;

    @Override
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    @Override
    public void validateToken(String token, CustomUserDetails userDetails) {
        jwtService.validateToken(token, userDetails);
    }

    @Override
    public Date getExpiryDate(String token) {
        return jwtService.extractExpirationDate(token);
    }
}
