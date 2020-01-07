package com.xavier.theordersapi.service;

import com.xavier.theordersapi.model.Order;
import com.xavier.theordersapi.repository.OrderItemRepository;
import com.xavier.theordersapi.repository.OrderRepository;
import com.xavier.theordersapi.session.ItemsTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemsTable itemsTable;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderItemRepository orderItemRepository;


    public Order save(Order order) {

        return null;
    }
}
