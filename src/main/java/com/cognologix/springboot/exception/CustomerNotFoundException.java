package com.cognologix.springboot.exception;

/**
 * The type Customer not found exception.
 */
public class CustomerNotFoundException extends Exception {
    /**
     * Instantiates a new Customer not found exception.
     *
     * @param message the message
     */
    public CustomerNotFoundException(String message) {
        super(message);
    }
}