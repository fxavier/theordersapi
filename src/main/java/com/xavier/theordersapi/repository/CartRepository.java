package com.xavier.theordersapi.repository;

import com.xavier.theordersapi.model.Cart;
import com.xavier.theordersapi.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserAccountUserId(Long userId);
}
