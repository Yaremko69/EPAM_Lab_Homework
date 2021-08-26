package com.example.lab5.exeption;

import com.example.lab5.model.enums.ErrorType;

public class RoomAlreadyBooked extends ServiceException {

    private static final String DEFAULT_MESSAGE = "This room is already booked at this time!";

    public RoomAlreadyBooked() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.FATAL_ERROR_TYPE;
    }
}
