package com.xavier.theordersapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "customer_id")
    private Long customerId;

    @NotNull(message = "customer-1")
    @Enumerated(EnumType.STRING)
    @Column(name = "customer_type")
    private CustomerType customerType;

    @NotBlank(message = "customer-2")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "customer-3")
    @Column(name = "last_name")
    private  String lastName;

    @NotBlank(message = "customer-4")
    @Email(message = "customer-5")
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<ShippingAddress> addresses = new ArrayList<>();

}
