package com.epam.mjc.exception;

public class CustomerException extends RuntimeException {

    public CustomerException() {
    }

    public CustomerException(String message) {
        super(message);
    }
}
