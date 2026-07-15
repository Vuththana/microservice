package org.goros.authenticationservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.goros.authenticationservice.service.AuthService;
import org.goros.authenticationservice.service.JwtService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    public final JwtService jwtService;


    @Override
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    @Override
    public void validateToken(String token) {

    }
}
