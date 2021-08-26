package com.example.lab5.api;

import com.example.lab5.controller.model.OrderModel;
import com.example.lab5.dto.OrderDto;
import com.example.lab5.dto.group.OnCreate;
import com.example.lab5.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "Order management API")
@RequestMapping("/api/v1/orders")
public interface OrderApi {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    OrderModel getOrder(@PathVariable long id);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<OrderModel> getAllActualOrders();

    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping
    OrderModel createOrder(@RequestBody @Validated(OnCreate.class) OrderDto orderDto);

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    OrderModel updateOrder(@PathVariable long id, @RequestBody @Validated(OnUpdate.class) OrderDto orderDto);

}
