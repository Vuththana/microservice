package org.goros.authenticationservice.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Date;

@Data
@Builder
public class LoginResponse {
    public String message;
    public HttpStatus status;
    public String token;
    public Date expiryDate;
    public Instant timestamp;
}
