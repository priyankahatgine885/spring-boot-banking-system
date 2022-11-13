package com.cognologix.springboot.exception;

public class EmptyListException extends RuntimeException{
    public EmptyListException(String exception) {
        super(exception);
    }
}
