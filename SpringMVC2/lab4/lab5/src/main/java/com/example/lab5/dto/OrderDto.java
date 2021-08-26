package com.example.lab5.dto;

import com.example.lab5.dto.group.OnCreate;
import com.example.lab5.dto.group.OnUpdate;
import com.example.lab5.model.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class OrderDto {

    @Null(message = "'id' should be absent in request", groups = {OnCreate.class, OnUpdate.class})
    private long id;

    @NotBlank(message = "'roomNumber' shouldn't be empty", groups = OnCreate.class)
    @Null(message = "'roomNumber' should be absent in request", groups = OnUpdate.class)
    private int roomNumber;

    @NotBlank(message = "'userEmail' shouldn't be empty", groups = OnCreate.class)
    @Null(message = "'userEmail' should be absent in request", groups = OnUpdate.class)
    private String userEmail;

    @NotBlank(message = "'dateFrom' shouldn't be empty", groups = OnCreate.class)
    @Null(message = "'dateFrom' should be absent in request", groups = OnUpdate.class)
    private String dateFrom;

    @NotBlank(message = "'dateTo' shouldn't be empty", groups = OnCreate.class)
    @Null(message = "'dateTo' should be absent in request", groups = OnUpdate.class)
    private String dateTo;

    @Null(message = "'orderDate' should be absent in request", groups = {OnUpdate.class, OnCreate.class})
    private String orderDate;

    @NotNull(message = "'status' shouldn't be empty", groups = OnUpdate.class)
    @Null(message = "'status' should be absent in request", groups = OnCreate.class)
    private OrderStatus status;
}
