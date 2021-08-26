package com.example.lab5.exeption;

import com.example.lab5.model.enums.ErrorType;

public class OrderNotFoundException extends ServiceException{

    private static final String DEFAULT_MESSAGE = "Order is not found!";

    public OrderNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.FATAL_ERROR_TYPE;
    }
}
