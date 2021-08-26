package com.example.lab5.controller.model;

import com.example.lab5.dto.RoomDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class RoomModel extends RepresentationModel<RoomModel> {

    @JsonUnwrapped
    private RoomDto roomDto;
}
