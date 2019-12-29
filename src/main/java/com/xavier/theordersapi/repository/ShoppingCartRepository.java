package com.xavier.theordersapi.repository;

import com.xavier.theordersapi.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
