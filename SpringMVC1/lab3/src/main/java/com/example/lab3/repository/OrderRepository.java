package com.example.lab3.repository;

import com.example.lab3.model.Order;

import java.util.List;

public interface OrderRepository {

    Order getOrder(long id);

    List<Order> getAllActualOrders();

    Order createOrder(Order order);

    Order updateOrder(String email,Order order);
}
