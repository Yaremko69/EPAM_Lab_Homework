package com.example.lab5.model;

import com.example.lab5.model.enums.OrderStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private long id;
    private int roomNumber;
    private String userEmail;
    private String dateFrom;
    private String dateTo;
    private String orderDate;
    private OrderStatus status;
}
