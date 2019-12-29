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
    private String email;

    @NotBlank(message = "user-2")
    private String password;

    @NotBlank(message = "user-3")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "user-4")
    @Column(name = "last_name")
    private  String lastName;

    @NotBlank(message = "user-5")
    private String phone;

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL)
    private List<ShippingAddress> addresses = new ArrayList<>();

    public boolean isNew() {
        return this.userId == null;
    }

    public boolean exist() {
        return this.userId != null;
    }
}
