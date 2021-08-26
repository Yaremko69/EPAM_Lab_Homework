package com.example.lab5.controller.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.lab5.controller.OrderController;
import com.example.lab5.controller.model.OrderModel;
import com.example.lab5.dto.OrderDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class OrderAssembler extends RepresentationModelAssemblerSupport<OrderDto, OrderModel> {

    public static final String GET_ORDER = "get_order";
    public static final String GET_ALL_ORDERS = "get_all_orders";
    public static final String CREATE_ORDER = "create_order";
    public static final String UPDATE_ORDER = "update_order";


    public OrderAssembler() {
        super(OrderController.class, OrderModel.class);
    }

    @Override
    public OrderModel toModel(OrderDto entity) {
        OrderModel orderModel = new OrderModel(entity);

        Link get = linkTo(methodOn(OrderController.class).getOrder(entity.getId())).withRel(GET_ORDER);
        Link getAll = linkTo(methodOn(OrderController.class).getAllActualOrders()).withRel(GET_ALL_ORDERS);
        Link create = linkTo(methodOn(OrderController.class).createOrder(entity)).withRel(CREATE_ORDER);
        Link update = linkTo(methodOn(OrderController.class).updateOrder(entity.getId(), entity))
                .withRel(UPDATE_ORDER);

        return orderModel.add(get, getAll, create, update);
    }
}
