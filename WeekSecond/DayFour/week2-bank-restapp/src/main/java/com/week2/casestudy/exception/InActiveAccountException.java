package com.week2.casestudy.exception;

public class InActiveAccountException extends RuntimeException {

    public InActiveAccountException(String message) {
        super(message);
    }
}