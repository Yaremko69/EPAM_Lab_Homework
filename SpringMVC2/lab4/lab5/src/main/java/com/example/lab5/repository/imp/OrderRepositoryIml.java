package com.example.lab5.repository.imp;

import com.example.lab5.exeption.OrderNotFoundException;
import com.example.lab5.model.Order;
import com.example.lab5.repository.OrderRepository;
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
                .orElseThrow(() -> new OrderNotFoundException());
    }

    @Override
    public List<Order> getAllActualOrders() {
        return list;
    }

    @Override
    public Order createOrder(Order order) {
        list.add(order);
        return order;
    }

    @Override
    public Order updateOrder(long id, Order order) {
        boolean isDeleted = list.removeIf(o -> o.getId() == id);
        if (isDeleted) {
            list.add(order);
        } else {
            throw new OrderNotFoundException();
        }
        return order;
    }

}
