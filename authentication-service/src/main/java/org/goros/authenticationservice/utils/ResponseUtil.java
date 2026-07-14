package org.goros.authenticationservice.utils;

import org.goros.authenticationservice.response.LoginResponse;
import org.springframework.http.HttpStatus;

import java.time.Instant;

public class ResponseUtil {
    private static final Instant now = Instant.now();

    public static LoginResponse loginResponse(String message, String token) {
        return LoginResponse.builder().success(true).message(message).status(HttpStatus.OK).token(token).timestamp(now).build();
    }
}
