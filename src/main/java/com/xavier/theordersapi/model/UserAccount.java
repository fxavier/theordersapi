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
@Table(name = "user_account")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "user_id")
    private Long userId;

    @NotBlank(message = "user-1")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "user-2")
    @Column(name = "last_name")
    private  String lastName;

    @NotBlank(message = "user-3")
    private String email;

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL)
    private List<ShippingAddress> addresses = new ArrayList<>();

}
