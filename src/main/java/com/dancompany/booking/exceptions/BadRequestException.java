package com.dancompany.booking.exceptions;

public class BadRequestException extends RuntimeException{

//    private String message;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

//    @Override
//    public String toString() {
//        return message;
//    }
}
