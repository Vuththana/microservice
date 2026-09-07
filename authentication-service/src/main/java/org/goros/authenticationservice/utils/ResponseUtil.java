package org.goros.authenticationservice.utils;

import org.goros.authenticationservice.dto.LoginResponse;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Date;

public class ResponseUtil {
    public static LoginResponse loginResponse(String message, String token, Date expiryDate) {
        return LoginResponse.builder().message(message).status(HttpStatus.OK).token(token).expiryDate(expiryDate).timestamp(Instant.now()).build();
    }
}
