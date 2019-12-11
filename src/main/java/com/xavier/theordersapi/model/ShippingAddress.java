package com.xavier.theordersapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "shipping_address")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "address_id")
    private Long addressId;

    private String village;

    private String street;

    private String number;

    @Enumerated(EnumType.STRING)
    private City city;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
