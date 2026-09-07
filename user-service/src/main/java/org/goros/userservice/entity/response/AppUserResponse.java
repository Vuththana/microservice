package org.goros.userservice.entity.response;

import lombok.Data;

import java.util.UUID;

@Data
public class AppUserResponse {
    public UUID userId;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
}
