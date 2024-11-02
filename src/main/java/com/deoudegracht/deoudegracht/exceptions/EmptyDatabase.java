package com.deoudegracht.deoudegracht.exceptions;

public class EmptyDatabase extends RuntimeException {
    public EmptyDatabase(String message) {
        super(message);
    }
}
