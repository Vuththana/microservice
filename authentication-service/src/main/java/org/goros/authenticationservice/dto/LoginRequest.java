package org.goros.authenticationservice.dto;

import lombok.Data;

@Data
public class LoginRequest {
    public String identifier;
    public String password;
}
