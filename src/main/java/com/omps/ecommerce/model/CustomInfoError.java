package com.omps.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Custom error response model returned to client
 * when an exception occurs.
 *
 * This class helps send structured error information
 * instead of plain error messages.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomInfoError {

    // HTTP status code (example: 404, 400, 500)
    private String status;

    // Error message describing the issue
    private String message;

    // Time when error occurred
    private String date;
}
