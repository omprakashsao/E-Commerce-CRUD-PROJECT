package com.omps.ecommerce.exception;

/**
 * Custom exception thrown when an Item
 * is not found in the system.
 *
 * This exception is usually thrown in the Service layer
 * and handled globally by GlobalExceptionHandler.
 */
public class ItemNotFoundException extends RuntimeException {

    /**
     * Default constructor.
     * Can be used when no custom message is needed.
     */
    public ItemNotFoundException() {}

    /**
     * Constructor with custom error message.
     *
     * @param message error details describing why exception occurred
     */
    public ItemNotFoundException(String message) {
        super(message); // passes message to RuntimeException
    }
}
