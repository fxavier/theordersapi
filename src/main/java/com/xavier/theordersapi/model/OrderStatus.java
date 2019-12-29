package com.xavier.theordersapi.model;

import lombok.Getter;

public enum OrderStatus {

    PENDENTE("Pendente"),
    CANCELADO("Cancelado"),
    CONFIRMADO("Confirmado"),
    ENTREGUE("Entregue"),
    FECHADO("Fechado");

    @Getter
    private String description;

    OrderStatus(String description) {
        this.description = description;
    }
}
