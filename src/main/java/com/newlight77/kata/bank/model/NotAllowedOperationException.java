package com.newlight77.kata.bank.model;


public class NotAllowedOperationException extends RuntimeException {

    public NotAllowedOperationException(String message) {
        super(message);
    }

}
