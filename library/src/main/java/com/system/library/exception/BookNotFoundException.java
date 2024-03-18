package com.system.library.exception;

public class BookNotFoundException extends RuntimeException{

    public String message1 = "Book not found";

    public BookNotFoundException(String message1) {
        super(message1);
    }

    public BookNotFoundException(String message1, Throwable cause) {
        super(message1, cause);
    }

    public BookNotFoundException(Throwable cause) {
        super(cause);
    }
}
