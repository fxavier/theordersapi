package com.xavier.theordersapi.service;

import com.xavier.theordersapi.model.CartItem;
import com.xavier.theordersapi.model.ShoppingCart;
import com.xavier.theordersapi.repository.CartItemRepository;
import com.xavier.theordersapi.repository.ShoppingCartRepository;
import com.xavier.theordersapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService productService;

    public ShoppingCartService(@Autowired ShoppingCartRepository shoppingCartRepository,
                               @Autowired CartItemRepository cartItemRepository,
                               @Autowired UserRepository userRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartItemRepository = cartItemRepository;
        this.userRepository = userRepository;
    }

    public ShoppingCart save(ShoppingCart shoppingCart) {
        shoppingCart.setUserAccount(shoppingCart.getUserAccount());
        shoppingCart = save(shoppingCart);

        for (CartItem cartItem : shoppingCart.getCartItems()) {
           cartItem.setProduct(productService.findById(cartItem.getProduct().getProductId()));
           cartItem.setUnitPrice(cartItem.getProduct().getNewPrice());
           cartItem.setShoppingCart(shoppingCart);
        }

        return shoppingCart;
    }
}
