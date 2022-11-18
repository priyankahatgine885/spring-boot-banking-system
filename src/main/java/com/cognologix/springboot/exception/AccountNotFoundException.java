package com.cognologix.springboot.exception;

/**
 * The type Account not found exception.
 */
public class AccountNotFoundException extends Exception {
    /**
     * Instantiates a new Account not found exception.
     *
     * @param message the message
     */
    public AccountNotFoundException(String message) {
        super(message);
    }
}