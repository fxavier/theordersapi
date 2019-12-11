package com.xavier.theordersapi.service.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public class BusnessException extends RuntimeException {

    private final String code;
    private final HttpStatus status;
}

