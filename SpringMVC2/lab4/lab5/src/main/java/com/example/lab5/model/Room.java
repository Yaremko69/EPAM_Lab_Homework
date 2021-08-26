package com.example.lab5.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Room {
    private int roomNumber;
    private int size;
    private String roomClass;
    private String descriptionEng;
    private String descriptionUa;
}
