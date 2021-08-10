package com.example.lab3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {
    private long id;
    private int roomNumber;
    private String userEmail;
    private String dateFrom;
    private String dateTo;
    private String orderDate;
}
