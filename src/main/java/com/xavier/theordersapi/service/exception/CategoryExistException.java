package com.xavier.theordersapi.service.exception;

import org.springframework.http.HttpStatus;

public class CategoryExistException extends BusnessException {
    public CategoryExistException() {
        super("category-2", HttpStatus.BAD_REQUEST);
    }
}
