package com.example.ChoThueXe.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {
    private final String message;

    public BadRequestException(String s) {
        message = s;
    }
}
