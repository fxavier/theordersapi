package com.xavier.theordersapi.repository;

import com.xavier.theordersapi.model.Cart;
import com.xavier.theordersapi.model.CartItem;
import com.xavier.theordersapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCart(Cart cart);

    Optional<CartItem> findByProduct(Product product);
}