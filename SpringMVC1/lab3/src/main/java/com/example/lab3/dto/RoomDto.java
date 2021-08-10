package com.example.lab3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDto {
    private int roomNumber;
    private int size;
    private String roomClass;

}
