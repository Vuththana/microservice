package org.goros.categoryservice.entity.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@Builder
public class ApiResponseVoid {
    public HttpStatus status;
    public String message;
    public boolean success;
    public Instant timestamp;
}
