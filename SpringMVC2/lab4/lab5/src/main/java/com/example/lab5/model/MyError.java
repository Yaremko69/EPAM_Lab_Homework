package com.example.lab5.model;

import com.example.lab5.model.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MyError {

    private String message;
    private ErrorType errorType;
    private LocalDateTime timeStamp;
}
