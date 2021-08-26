package com.example.lab5.service;

import com.example.lab5.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto getOrder(long id);

    List<OrderDto> getAllActualOrders();

    OrderDto createOrder(OrderDto orderDto);

    OrderDto updateOrder(long id, OrderDto orderDto);
}
