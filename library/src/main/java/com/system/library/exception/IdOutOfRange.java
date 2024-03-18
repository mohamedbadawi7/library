package com.system.library.exception;

public class IdOutOfRange extends RuntimeException{


    public String message1 = "ID out of range";

    public IdOutOfRange(String message1) {
        super(message1);
    }

    public IdOutOfRange(String message1, Throwable cause) {
        super(message1, cause);
    }

    public IdOutOfRange(Throwable cause) {
        super(cause);
    }
}
