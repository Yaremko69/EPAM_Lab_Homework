package com.example.lab3.controller;

import com.example.lab3.dto.OrderDto;
import com.example.lab3.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /*
    - under development
    public OrderDto getOrder(long id){return null;}
     */

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/orders")
    public List<OrderDto> getAllActualOrders() {
        return orderService.getAllActualOrders();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping(value = "/orders")
    public OrderDto createOrder(@RequestBody  OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/orders/{email}")
    public OrderDto updateOrder(@PathVariable String email,@RequestBody OrderDto orderDto) {
        return orderService.updateOrder(email, orderDto);
    }
}
