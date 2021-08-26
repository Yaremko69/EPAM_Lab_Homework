package com.example.lab5.exeption;

import com.example.lab5.model.enums.ErrorType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class ServiceException extends RuntimeException {

    private ErrorType errorType;

    public ServiceException (String message){
        super(message);
    }

    public ErrorType getErrorType(){
        return errorType.FATAL_ERROR_TYPE;
    }
}
