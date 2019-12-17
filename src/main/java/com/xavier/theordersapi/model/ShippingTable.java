package com.xavier.theordersapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "shipping_table")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ShippingTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "table_id")
    private Long tableId;

    @ManyToOne
    @JoinColumn(name = "village_id")
    private Village village;

    @NotNull(message = "table-1")
    private BigDecimal price;


}
