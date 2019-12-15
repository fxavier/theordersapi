package com.xavier.theordersapi.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@JsonTypeName("credit_card")
@Data
public class CreditCard extends Payment {

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "holder_name")
    private String holderName;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiry_month")
    private String expiryMonth;

    @Column(name = "expiry_year")
    private Integer expiryYear;

    private Integer cvc;

}
