package com.example.lab5.dto;

import com.example.lab5.dto.group.OnCreate;
import com.example.lab5.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class RoomDto {

    @NotNull(message = "'roomNumber' shouldn't be empty", groups = OnCreate.class)
    @Null(message = "'roomNumber' should be absent in request", groups = OnUpdate.class)
    private int roomNumber;

    @NotNull(message = "'size' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private int size;

    @NotNull(message = "'roomClass' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String roomClass;

    @NotNull(message = "'descriptionEng' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String descriptionEng;

    @NotNull(message = "'descriptionUa' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String descriptionUa;

}
