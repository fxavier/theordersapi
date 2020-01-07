package com.xavier.theordersapi.service;

import com.xavier.theordersapi.model.Cart;
import com.xavier.theordersapi.model.CartItem;
import com.xavier.theordersapi.model.Product;
import com.xavier.theordersapi.model.UserAccount;
import com.xavier.theordersapi.repository.CartItemRepository;
import com.xavier.theordersapi.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    public Cart findCartByUser(Long  userId) {
        return cartRepository.findByUserAccountUserId(userId);
    }

    public Cart save(Cart cart) {
        cart.setUserAccount(userService.findById(cart.getUserAccount().getUserId()));
        cart = cartRepository.save(cart);
        for (CartItem item: cart.getCartItems()) {
            item.setProduct(productService.findById(item.getProduct().getProductId()));
            item.setUnitPrice(item.getProduct().getNewPrice());
            item.setSubtotal(item.getUnitPrice().multiply(new BigDecimal(item.getQuantity())));
            item.setCart(cart);
        }

        cartItemRepository.saveAll(cart.getCartItems());
        updateCart(cart);
        return cart;
    }

    public Cart updateCart(Cart cart) {
        List<CartItem> cartItems = cartItemRepository.findByCart(cart);
        BigDecimal cartTotal = cartItems.stream()
                .map(CartItem::getSubtotal)
                .reduce(BigDecimal::add)
                .get();
        cart.setGrandTotal(cartTotal);
        return cartRepository.save(cart);
    }



}
