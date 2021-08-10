package com.example.lab3.service;

import com.example.lab3.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto getOrder(long id);

    List<OrderDto> getAllActualOrders();

    OrderDto createOrder(OrderDto orderDto);

    OrderDto updateOrder(String email, OrderDto orderDto);
}
