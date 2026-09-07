package org.goros.authenticationservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AuthUserResponse {
    public UUID userId;
    public String username;
    public String email;
    public String password;
}
