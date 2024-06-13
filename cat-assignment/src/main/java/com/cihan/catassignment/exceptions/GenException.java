package com.cihan.catassignment.exceptions;

import lombok.Getter;

@Getter
public class GenException extends RuntimeException {
    private final int statusCode;

    public GenException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

}
