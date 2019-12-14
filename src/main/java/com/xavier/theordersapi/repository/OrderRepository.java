package com.xavier.theordersapi.repository;

import com.xavier.theordersapi.model.Customer;
import com.xavier.theordersapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByCustomer(Customer customer);
}
