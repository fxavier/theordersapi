package com.xavier.theordersapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "grand_total")
    private BigDecimal grandTotal = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CartItem> cartItems;

    public BigDecimal getGrandTotal() {
        return cartItems.stream()
                .map(CartItem::getSubtotal)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
