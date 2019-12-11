package com.xavier.theordersapi.model;

import lombok.Getter;

public enum PaymentStatus {

    PENDENTE("Pendente"),
    QUITADO("Quitado"),
    CANCELADO("Cancelado");

    @Getter
    private String description;

    PaymentStatus(String description) {
        this.description = description;
    }
}
