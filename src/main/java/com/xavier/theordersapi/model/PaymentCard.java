package com.xavier.theordersapi.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@JsonTypeName("payment_card")
@Data
public class PaymentCard extends Payment {

    @Column(name = "number_of_portions")
    private Integer numberOfPortions;
}
