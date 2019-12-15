package com.xavier.theordersapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    @NotBlank(message = "address-1")
    private String village;

    @NotBlank(message = "address-2")
    private String street;

    private String number;

    @Enumerated(EnumType.STRING)
    private City city;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;
}
