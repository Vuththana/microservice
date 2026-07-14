package org.goros.authenticationservice.dto;

import lombok.Data;

@Data
public class AppUserRequest {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
}
