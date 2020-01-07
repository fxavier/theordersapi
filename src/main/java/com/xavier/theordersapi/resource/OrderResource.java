package com.xavier.theordersapi.resource;

import com.xavier.theordersapi.model.Order;
import com.xavier.theordersapi.service.OrderService;
import com.xavier.theordersapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderResource {

    @Autowired
   private OrderService orderService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@Valid @RequestBody Order order) {
      return orderService.save(order);
    }



}
