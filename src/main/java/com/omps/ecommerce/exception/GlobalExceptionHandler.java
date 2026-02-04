package com.omps.ecommerce.exception;

import com.omps.ecommerce.model.CustomInfoError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for the entire application.
 *
 * Any exception thrown from controllers or services
 * will be handled here and converted into proper HTTP responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles validation errors when request body validation fails.
     * Example: @NotBlank, @NotNull, etc.
     *
     * Returns a map of:
     * fieldName -> error message
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(
            MethodArgumentNotValidException ex) {

        // Map to store validation errors
        Map<String, String> errors = new HashMap<>();

        // Extract field errors and store them in map
        ex.getBindingResult().getFieldErrors()
                .forEach(error ->
                        errors.put(
                                error.getField(),          // field name
                                error.getDefaultMessage()  // validation message
                        ));

        // Return HTTP 400 with validation error details
        return ResponseEntity.badRequest().body(errors);
    }

    /**
     * Handles custom exception when item is not found.
     *
     * Returns structured error information with timestamp.
     */
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<CustomInfoError> handleItemNotFound(
            ItemNotFoundException ex
    ) {

        // Create custom error response object
        CustomInfoError error = new CustomInfoError(
                "404",
                ex.getMessage(),
                new Date().toString()
        );

        // Return HTTP 404 status with error body
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
