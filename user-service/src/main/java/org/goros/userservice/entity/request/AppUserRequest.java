package org.goros.userservice.entity.request;

import lombok.Data;

@Data
public class AppUserRequest {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
}
