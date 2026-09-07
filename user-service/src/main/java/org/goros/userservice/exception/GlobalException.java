package org.goros.userservice.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFound(UserNotFoundException ex, HttpServletRequest request) {
        Map<String, Object> map = new LinkedHashMap<>();
        HttpStatus status = HttpStatus.NOT_FOUND;
        map.put("title", "Not Found");
        map.put("status", status.value());
        map.put("detail", ex.getMessage());
        map.put("instant", request.getRequestURI());
        map.put("success", false);

        return ResponseEntity.status(status).body(map);
    }
}
