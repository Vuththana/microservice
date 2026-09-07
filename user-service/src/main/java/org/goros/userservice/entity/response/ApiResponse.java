package org.goros.userservice.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    public String message;
    public HttpStatus status;
    public Boolean success;
    public T payload;
    public Instant timestamp;
}
