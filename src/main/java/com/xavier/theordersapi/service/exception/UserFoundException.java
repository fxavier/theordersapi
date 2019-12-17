package com.xavier.theordersapi.service.exception;

import org.springframework.http.HttpStatus;

public class UserFoundException extends BusnessException {
    public UserFoundException() {
        super("user-6", HttpStatus.BAD_REQUEST);
    }
}
