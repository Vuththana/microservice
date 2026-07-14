package org.goros.authenticationservice.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@Builder
public class LoginResponse {
    public Boolean success;
    public String message;
    public HttpStatus status;
    public String token;
    public Instant timestamp;
}
