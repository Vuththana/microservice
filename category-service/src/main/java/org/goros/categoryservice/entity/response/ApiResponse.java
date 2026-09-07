package org.goros.categoryservice.entity.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@Builder
public class ApiResponse<T> {
    public HttpStatus status;
    public String message;
    public boolean success;
    public Instant timestamp;
    public T payload;
}
