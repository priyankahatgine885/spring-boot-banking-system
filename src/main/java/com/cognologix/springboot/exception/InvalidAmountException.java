package com.cognologix.springboot.exception;

public class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}
