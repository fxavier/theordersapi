package com.xavier.theordersapi.service.exception;

import org.springframework.http.HttpStatus;

public class ProducrNotFoundException extends BusnessException {
    public ProducrNotFoundException() {
        super("product-7", HttpStatus.BAD_REQUEST);
    }
}
