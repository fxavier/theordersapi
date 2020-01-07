package com.xavier.theordersapi.service;

import com.xavier.theordersapi.model.Cart;
import com.xavier.theordersapi.model.CartItem;
import com.xavier.theordersapi.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> findByCart(Cart cart) {
        return cartItemRepository.findByCart(cart);
    }

    public CartItem updateCartItem(CartItem cartItem) {
        cartItem.setQuantity(cartItem.getQuantity());
        BigDecimal subtotal = cartItem.getProduct().getNewPrice().multiply(new BigDecimal(cartItem.getQuantity()));
        cartItem.setSubtotal(subtotal);

        return cartItemRepository.save(cartItem);
    }

    public CartItem findById(Long id) {
        return cartItemRepository.getOne(id);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }

    public CartItem save(final CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }
}
