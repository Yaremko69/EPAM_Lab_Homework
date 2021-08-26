package com.example.lab5.controller;

import com.example.lab5.api.OrderApi;
import com.example.lab5.controller.assembler.OrderAssembler;
import com.example.lab5.controller.model.OrderModel;
import com.example.lab5.dto.OrderDto;
import com.example.lab5.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {

    private final OrderService orderService;
    private final OrderAssembler orderAssembler;

    @Override
    public OrderModel getOrder(long id) {
        OrderDto orderDto = orderService.getOrder(id);
        return orderAssembler.toModel(orderDto);
    }

    // - Under development
    @Override
    public List<OrderModel> getAllActualOrders() {
        List<OrderModel> list = new ArrayList<>();
        for (OrderDto order: orderService.getAllActualOrders()){
            list.add(orderAssembler.toModel(order));
        }
        return list;
    }

    @Override
    public OrderModel createOrder(OrderDto orderDto) {
        OrderDto order = orderService.createOrder(orderDto);
        return orderAssembler.toModel(order);
    }

    @Override
    public OrderModel updateOrder(long id, OrderDto orderDto) {
        OrderDto order = orderService.updateOrder(id, orderDto);
        return orderAssembler.toModel(order);
    }
}
