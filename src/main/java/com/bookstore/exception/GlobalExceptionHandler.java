package com.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Global Exception Handler to manage exceptions across the application.
 * It provides a centralized way to handle exceptions and return meaningful error responses.
 */
@ControllerAdvice  // This annotation makes the class handle exceptions globally for all controllers
public class GlobalExceptionHandler {

    /**
     * Handles RuntimeExceptions thrown in the application.
     * Returns a structured JSON response with error details.
     *
     * @param ex The RuntimeException that occurred
     * @return ResponseEntity containing error details
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
        // Creating a structured error response
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());  // Current timestamp
        errorResponse.put("status", HttpStatus.NOT_FOUND.value());  // HTTP status code (404)
        errorResponse.put("error", "Not Found");  // Error message
        errorResponse.put("message", ex.getMessage());  // Exception message

        // Returning the error response with 404 status
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
