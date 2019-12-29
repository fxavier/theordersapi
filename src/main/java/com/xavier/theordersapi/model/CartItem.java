package com.xavier.theordersapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cart_item")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "item_id")
    private Long cartItemId;

    private Integer quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private ShoppingCart shoppingCart;

    public BigDecimal getSubTotal() {
        return unitPrice.multiply(new BigDecimal(quantity));
    }
}
