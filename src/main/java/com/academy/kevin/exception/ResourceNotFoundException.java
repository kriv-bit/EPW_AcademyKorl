package com.academy.kevin.exception;

/**
 * Custom exception for missing resources [cite: 263-265].
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message); // Pass the message to the parent RuntimeException [cite: 266]
    }
}