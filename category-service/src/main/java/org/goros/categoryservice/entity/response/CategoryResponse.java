package org.goros.categoryservice.entity.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@Builder
public class CategoryResponse<T> {
    public HttpStatus status;
    public boolean success;
    public String message;
    public T payload;
    public Instant timestamp;
}
