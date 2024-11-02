package com.deoudegracht.deoudegracht.exceptions;

public class ExistingUsernameException extends RuntimeException {
    public ExistingUsernameException(String message) {
        super(message);
    }
}
