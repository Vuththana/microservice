package org.goros.categoryservice.utils;

import org.goros.categoryservice.entity.response.ApiResponse;
import org.goros.categoryservice.entity.response.ApiResponseVoid;
import org.springframework.http.HttpStatus;

import java.time.Instant;

public class ResponseUtil {
    private static final Instant now = Instant.now();

    public static<T> ApiResponse<T> success(String message, T payload) {
        return ApiResponse.<T>builder().message(message).status(HttpStatus.OK).success(true).payload(payload).timestamp(now).build();
    }

    public static ApiResponseVoid successVoid(String message) {
        return ApiResponseVoid.builder().message(message).status(HttpStatus.OK).success(true).timestamp(now).build();
    }
}
