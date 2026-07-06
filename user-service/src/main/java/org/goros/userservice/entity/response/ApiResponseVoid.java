package org.goros.userservice.entity.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@Builder
public class ApiResponseVoid {
    public String message;
    public Boolean success;
    public HttpStatus status;
    public Instant timestamp;
}
