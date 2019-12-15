package com.xavier.theordersapi.service.exception;

import org.springframework.http.HttpStatus;

public class ProductExistException extends BusnessException {
    public ProductExistException() {
        super("product-6", HttpStatus.BAD_REQUEST);
    }
}
