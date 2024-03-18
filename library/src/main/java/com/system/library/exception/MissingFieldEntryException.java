package com.system.library.exception;

public class MissingFieldEntryException extends RuntimeException{

    public MissingFieldEntryException(String message) {
        super(message);
    }

    public MissingFieldEntryException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingFieldEntryException(Throwable cause) {
        super(cause);
    }
}
