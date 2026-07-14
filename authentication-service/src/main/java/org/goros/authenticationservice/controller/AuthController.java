package org.goros.authenticationservice.controller;

import lombok.RequiredArgsConstructor;
import org.goros.authenticationservice.dto.LoginRequest;
import org.goros.authenticationservice.jwt.JwtService;
import org.goros.authenticationservice.response.LoginResponse;
import org.goros.authenticationservice.service.AuthService;
import org.goros.authenticationservice.utils.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auths")
public class AuthController {
    public final AuthService authService;
    public final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    private void authenticate(String identifier, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(identifier, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest request) throws Exception {
        authenticate(request.getIdentifier(), request.getPassword());
        final UserDetails userDetails = authService.loadUserByUsername(request.getIdentifier());
        final String token = jwtService.generateToken(userDetails);
        LoginResponse response = ResponseUtil.loginResponse("Login Successfully", token);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
