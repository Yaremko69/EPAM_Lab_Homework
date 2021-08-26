package com.example.lab5.exeption;

import com.example.lab5.model.enums.ErrorType;

public class UserNotFoundException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "User is not found!";

    public UserNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.FATAL_ERROR_TYPE;
    }
}
