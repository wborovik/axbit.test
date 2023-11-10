package com.example.axbit.test.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ObjectNotSavedException extends RuntimeException {
    public ObjectNotSavedException(String message) {
        super(message);
    }
}