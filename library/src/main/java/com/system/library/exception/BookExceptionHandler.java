package com.system.library.exception;

public class BookExceptionHandler extends RuntimeException{

    public BookExceptionHandler(String message) {
        super(message);
    }

    public BookExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public BookExceptionHandler(Throwable cause) {
        super(cause);
    }
}
