package com.example.lab5.exeption;

import com.example.lab5.model.enums.ErrorType;

public class UserAlreadyExist extends ServiceException {

    private static final String DEFAULT_MESSAGE = "User with this email is already exist";

    public UserAlreadyExist() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.FATAL_ERROR_TYPE;
    }
}
