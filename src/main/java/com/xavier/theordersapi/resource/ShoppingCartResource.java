package com.xavier.theordersapi.resource;

import com.xavier.theordersapi.model.ShoppingCart;
import com.xavier.theordersapi.repository.ShoppingCartRepository;
import com.xavier.theordersapi.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class ShoppingCartResource {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @GetMapping
    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingCart create(@Valid @RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.save(shoppingCart);
    }
}
