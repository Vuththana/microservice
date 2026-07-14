package org.goros.authenticationservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AppUserResponse {
    public UUID userId;
    public String firstName;
    public String lastName;
    public String email;
    public String username;
}
