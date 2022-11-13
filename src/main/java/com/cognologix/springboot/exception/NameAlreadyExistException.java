package com.cognologix.springboot.exception;

public class NameAlreadyExistException extends RuntimeException{
    public NameAlreadyExistException(String exception) {
        super(exception);
    }
}
