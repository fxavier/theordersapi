package com.xavier.theordersapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotNull(message = "address-1")
    @ManyToOne
    @JoinColumn(name = "village_id")
    private Village village;

    @NotBlank(message = "address-2")
    private String street;

    @NotNull(message = "address-3")
    private String number;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;
}
