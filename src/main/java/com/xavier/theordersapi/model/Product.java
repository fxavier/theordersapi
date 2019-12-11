package com.xavier.theordersapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Column(name = "product_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
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

    @ManyToMany
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();

    public boolean isNew() {
        return this.productId == null;
    }

    public boolean exists() {
        return this.productId != null;
    }
}
