package com.system.library.exception;

public class IncorrectISBNFormat extends RuntimeException{

    public IncorrectISBNFormat(String message) {
        super(message);
    }

    public IncorrectISBNFormat(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectISBNFormat(Throwable cause) {
        super(cause);
    }
}
