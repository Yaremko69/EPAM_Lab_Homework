package com.example.lab3.repository.imp;

import com.example.lab3.model.Order;
import com.example.lab3.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepositoryIml implements OrderRepository {

    private final List<Order> list = new ArrayList<>();

    @Override
    public Order getOrder(long id) {
        return list.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order is not found!"));
    }

    @Override
    public List<Order> getAllActualOrders() {
        if (list.isEmpty()) {
            throw new RuntimeException("No orders!");
        }
        return list;
    }

    @Override
    public Order createOrder(Order order) {
        list.add(order);
        return order;
    }

    @Override
    public Order updateOrder(String email, Order order) {
        boolean isDeleted = list.removeIf(o -> o.getUserEmail().equals(email));
        if (isDeleted) {
            list.add(order);
        } else {
            throw new RuntimeException("Order is not found!");
        }
        return order;
    }

}
