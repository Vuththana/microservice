package org.goros.userservice.entity.response;

import lombok.Data;

import java.util.UUID;

@Data
public class InternalAppUserResponse {
    public UUID userId;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
}
