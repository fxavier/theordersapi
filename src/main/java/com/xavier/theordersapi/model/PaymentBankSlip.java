package com.xavier.theordersapi.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@JsonTypeName("payment_bank_slip")
@Data
public class PaymentBankSlip extends Payment {

    @Column(name = "expire_date")
    private LocalDate expireDate;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

}
