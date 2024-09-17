package com.riwi.example_SS_JWT.domain.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException (String message) {
        super(message);
    }
}
