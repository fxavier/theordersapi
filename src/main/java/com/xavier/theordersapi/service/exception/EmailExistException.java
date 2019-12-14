package com.xavier.theordersapi.service.exception;

import org.springframework.http.HttpStatus;

public class EmailExistException extends BusnessException {
    public EmailExistException() {
        super("customer-6", HttpStatus.BAD_REQUEST);
    }
}
