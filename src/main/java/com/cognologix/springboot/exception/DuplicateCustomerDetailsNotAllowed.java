package com.cognologix.springboot.exception;

/**
 * The type Name already exist exception.
 */
public class DuplicateCustomerDetailsNotAllowed extends RuntimeException {
    /**
     * Instantiates a new Name already exist exception.
     *
     * @param exception the exception
     */
    public DuplicateCustomerDetailsNotAllowed(String exception) {
        super(exception);
    }
}
