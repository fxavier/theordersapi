package com.xavier.theordersapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "cart_total")
    private BigDecimal cartTotal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> cartItems = new ArrayList<>();

    public BigDecimal getTotalPrice() {
        return cartItems.stream()
                .map(CartItem::getSubTotal)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public void addItems(List<CartItem> items) {
        this.cartItems = items;
        cartItems.forEach(cartItem -> cartItem.setShoppingCart(this));
    }
}
