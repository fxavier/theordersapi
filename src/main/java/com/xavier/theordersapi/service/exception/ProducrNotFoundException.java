package com.xavier.theordersapi.service.exception;

import org.springframework.http.HttpStatus;

public class ProducrNotFoundException extends BusnessException {
    public ProducrNotFoundException() {
        super("product-6", HttpStatus.BAD_REQUEST);
    }
}
