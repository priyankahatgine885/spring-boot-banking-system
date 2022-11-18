package com.cognologix.springboot.exception;

/**
 * The type Name already exist exception.
 */
public class NameAlreadyExistException extends RuntimeException {
    /**
     * Instantiates a new Name already exist exception.
     *
     * @param exception the exception
     */
    public NameAlreadyExistException(String exception) {
        super(exception);
    }
}
