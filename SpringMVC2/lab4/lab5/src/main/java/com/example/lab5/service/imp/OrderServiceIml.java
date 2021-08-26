package com.example.lab5.service.imp;

import com.example.lab5.dto.OrderDto;
import com.example.lab5.model.Order;
import com.example.lab5.repository.OrderRepository;
import com.example.lab5.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceIml implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderDto getOrder(long id) {
        log.info("getOrder by id {}", id);
        Order order = orderRepository.getOrder(id);
        return mapOrderToOrderDto(order);
    }

    @Override
    public List<OrderDto> getAllActualOrders() {
        log.info("getAllActualOrders");
        List<OrderDto> listDto = new ArrayList<>();
        for (Order order : orderRepository.getAllActualOrders()) {
            listDto.add(mapOrderToOrderDto(order));
        }
        return listDto;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        log.info("createOrder, user's email is {}", orderDto.getUserEmail());
        Order order = mapOrderDtoToOrder(orderDto);
        order = orderRepository.createOrder(order);
        return mapOrderToOrderDto(order);
    }

    @Override
    public OrderDto updateOrder(long id, OrderDto orderDto) {
        log.info("updateOrder, user's email is {}", orderDto.getUserEmail());
        Order order = mapOrderDtoToOrder(orderDto);

        Order oldOrder = orderRepository.getOrder(id);
        oldOrder.setStatus(order.getStatus());

        order = orderRepository.updateOrder(id, oldOrder);
        return mapOrderToOrderDto(order);
    }


    private OrderDto mapOrderToOrderDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .roomNumber(order.getRoomNumber())
                .userEmail(order.getUserEmail())
                .dateFrom(order.getDateFrom())
                .dateTo(order.getDateTo())
                .orderDate(order.getOrderDate())
                .status(order.getStatus())
                .build();
    }

    private Order mapOrderDtoToOrder(OrderDto orderDto) {
        return Order.builder()
                .roomNumber(orderDto.getRoomNumber())
                .userEmail(orderDto.getUserEmail())
                .dateFrom(orderDto.getDateFrom())
                .dateTo(orderDto.getDateTo()).orderDate(orderDto.getOrderDate())
                .build();
    }

}
