package com.example.lab5.dto;

import com.example.lab5.dto.group.OnCreate;
import com.example.lab5.dto.group.OnUpdate;
import com.example.lab5.model.enums.UserRequestStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class UserRequestDto {

    @Null(message = "'id' should be absent in request", groups = {OnCreate.class, OnUpdate.class})
    private long id;

    @Email
    @NotBlank(message = "'firstName' shouldn't be empty", groups = OnCreate.class)
    @Null(message = "'email' should be absent in request", groups = OnUpdate.class)
    private String userEmail;

    @NotBlank(message = "'firstName' shouldn't be empty", groups = OnCreate.class)
    @Null(message = "'email' should be absent in request", groups = OnUpdate.class)
    private String roomClass;

    @NotBlank(message = "'firstName' shouldn't be empty", groups = OnCreate.class)
    @Null(message = "'email' should be absent in request", groups = OnUpdate.class)
    private int size;

    @NotBlank(message = "'firstName' shouldn't be empty", groups = OnCreate.class)
    @Null(message = "'email' should be absent in request", groups = OnUpdate.class)
    private String dateFrom;

    @NotBlank(message = "'firstName' shouldn't be empty", groups = OnCreate.class)
    @Null(message = "'email' should be absent in request", groups = OnUpdate.class)
    private String dateTo;

    @Null(message = "'email' should be absent in request", groups = {OnUpdate.class, OnCreate.class})
    private String requestDate;

    @NotNull(message = "'firstName' shouldn't be empty", groups = OnUpdate.class)
    @Null(message = "'email' should be absent in request", groups = OnCreate.class)
    private UserRequestStatus status;

}
