package org.goros.authenticationservice.service.impl;

import org.goros.authenticationservice.service.AuthService;
import org.goros.authenticationservice.service.JwtService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    public JwtService jwtService;


    @Override
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    @Override
    public void validateToken(String token) {

    }
}
