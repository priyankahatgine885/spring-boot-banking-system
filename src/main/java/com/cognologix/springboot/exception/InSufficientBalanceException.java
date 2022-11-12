package com.cognologix.springboot.exception;

public class InSufficientBalanceException extends Exception{
    public InSufficientBalanceException(String message) {
        super(message);
    }
}
