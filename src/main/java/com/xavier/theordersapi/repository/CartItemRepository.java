package com.xavier.theordersapi.repository;

import com.xavier.theordersapi.model.CartItem;
import com.xavier.theordersapi.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
}
