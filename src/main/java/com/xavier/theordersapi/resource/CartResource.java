package com.xavier.theordersapi.resource;

import com.xavier.theordersapi.model.Cart;
import com.xavier.theordersapi.model.UserAccount;
import com.xavier.theordersapi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/carts")
public class CartResource {

    @Autowired
    private CartService cartService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cart create(@Valid @RequestBody Cart cart) {
        return cartService.save(cart);
    }

    @GetMapping
    public Cart findByUser(@RequestParam Long userId) {
        return cartService.findCartByUser(userId);
    }




}
