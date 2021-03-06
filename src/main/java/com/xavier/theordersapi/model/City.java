package com.xavier.theordersapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "city")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "city_id")
    private Long cityId;

    @NotBlank(message = "city-1")
    @Column(name = "city_name")
    private String cityName;

    @NotNull(message = "city-2")
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
