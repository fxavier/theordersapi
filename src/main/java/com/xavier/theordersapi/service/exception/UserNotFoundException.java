package com.xavier.theordersapi.service.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BusnessException {
    public UserNotFoundException() {
        super("user-7", HttpStatus.BAD_REQUEST);
    }
}
