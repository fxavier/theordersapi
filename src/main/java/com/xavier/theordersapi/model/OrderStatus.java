package com.xavier.theordersapi.model;

import lombok.Getter;

public enum OrderStatus {

    PENDENTE("Pendente"),
    CANCELADO("Cancelado"),
    CONFIRMADO("Confirmado");

    @Getter
    private String description;

    OrderStatus(String description) {
        this.description = description;
    }
}
