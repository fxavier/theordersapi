package com.xavier.theordersapi.service;

import com.xavier.theordersapi.model.CartItem;
import com.xavier.theordersapi.model.Product;
import com.xavier.theordersapi.model.UserAccount;
import com.xavier.theordersapi.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItemService(@Autowired CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public CartItem addItemToCart(UserAccount user, Product product, Integer quantity) {
        return null;
    }


}
