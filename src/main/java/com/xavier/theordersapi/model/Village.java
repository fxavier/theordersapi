package com.xavier.theordersapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "village")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Village {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "village_id")
    private Long villageId;

    @NotBlank(message = "village-1")
    @Column(name = "village_name")
    private String villageName;

    @NotNull(message = "village-2")
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
