package com.xavier.theordersapi.model;

import lombok.Getter;

public enum CustomerType {

    EMPRESA("Empresa"),
    PARTICULAR("Particular");

    @Getter
    private String description;


    CustomerType(String description) {
        this.description = description;
    }
}
