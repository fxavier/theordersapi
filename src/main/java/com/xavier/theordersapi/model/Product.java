package com.xavier.theordersapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "product_id")
    private Long productId;

    @NotBlank(message = "product-1")
    @Column(name = "product_name")
    private String productName;

    private String description;

    @NotNull(message = "product-2")
    @Column(name = "old_price")
    private BigDecimal oldPrice;

    @NotNull(message = "product-3")
    private BigDecimal descount;

    @NotNull(message = "product-4")
    @Column(name = "new_price")
    private BigDecimal newPrice;

    @NotNull(message = "product-5")
    private Integer quantity;


    public boolean isNew() {
        return this.productId == null;
    }

    public boolean exists() {
        return this.productId != null;
    }
}
