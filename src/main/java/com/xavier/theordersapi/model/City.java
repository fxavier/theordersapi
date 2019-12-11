package com.xavier.theordersapi.model;

import lombok.Getter;


public enum City {

    MAPUTO("Maputo"),
    MATOLA("Matola"),
    XAIXAI("Xai-Xai"),
    INHAMBANE("Inhambane"),
    BEIRA("Beira"),
    CHIMOIO("Chimoio"),
    TETE("Tete"),
    NAMPULA("Nampula"),
    PEMBA("Pemba"),
    LICHINGA("Lichinga");

    @Getter
    private String description;

    City(String description) {
        this.description = description;
    }
}
