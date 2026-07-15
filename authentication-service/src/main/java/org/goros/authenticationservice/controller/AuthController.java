package org.goros.authenticationservice.controller;

import lombok.RequiredArgsConstructor;
import org.goros.authenticationservice.dto.LoginRequest;
import org.goros.authenticationservice.dto.LoginResponse;
import org.goros.authenticationservice.service.AuthService;
import org.goros.authenticationservice.utils.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auths")
@RequiredArgsConstructor
public class AuthController {
    public final AuthService service;
    public final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        Authentication authenticated = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getIdentifier(), request.getPassword()));
        if(authenticated.isAuthenticated()) {
            String token = service.generateToken(request.getIdentifier());
            LoginResponse response = ResponseUtil.loginResponse("Login Successfully", token, service.getExpiryDate(token));
            return ResponseEntity.status(response.getStatus()).body(response);
        } else {
            throw new AuthenticationCredentialsNotFoundException("Wrong Credentials.");
        }
    }
}
