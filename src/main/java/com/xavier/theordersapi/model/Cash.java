package com.xavier.theordersapi.model;

import javax.persistence.Column;
import java.time.LocalDate;

public class Cash extends Payment{

    @Column(name = "payment_date")
    private LocalDate paymentDate;

}
