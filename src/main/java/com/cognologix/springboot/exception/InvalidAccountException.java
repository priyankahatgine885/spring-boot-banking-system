package com.cognologix.springboot.exception;

public class InvalidAccountException extends Exception{
    public InvalidAccountException(String message) {
        super(message);
    }
}
