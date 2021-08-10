package com.example.lab3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {
    private long id;
    private String userEmail;
    private String roomClass;
    private int size;
    private String dateFrom;
    private String dateTo;
    private String requestDate;

}
