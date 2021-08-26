package com.example.lab5.model;

import com.example.lab5.model.enums.UserRequestStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    private long id;
    private String userEmail;
    private String roomClass;
    private int size;
    private String dateFrom;
    private String dateTo;
    private String requestDate;
    private UserRequestStatus status;
}
