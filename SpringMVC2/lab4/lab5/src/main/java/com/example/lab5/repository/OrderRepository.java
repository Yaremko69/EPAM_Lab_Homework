package com.example.lab5.repository;

import com.example.lab5.model.Order;

import java.util.List;

public interface OrderRepository {

    Order getOrder(long id);

    List<Order> getAllActualOrders();

    Order createOrder(Order order);

    Order updateOrder(long id,Order order);
}
