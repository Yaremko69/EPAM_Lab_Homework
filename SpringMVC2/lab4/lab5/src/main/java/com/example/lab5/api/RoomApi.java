package com.example.lab5.api;

import com.example.lab5.controller.model.RoomModel;
import com.example.lab5.dto.RoomDto;
import com.example.lab5.dto.group.OnCreate;
import com.example.lab5.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Room management API")
@RequestMapping("/api/v1/rooms")
public interface RoomApi {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{roomNumber}")
    RoomModel getRoom(@PathVariable int roomNumber);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<RoomModel> getAllRooms();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    RoomModel createRoom(@RequestBody @Validated(OnCreate.class) RoomDto roomDto);

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{roomNumber}")
    RoomModel updateRoom(@PathVariable int roomNumber, @RequestBody @Validated(OnUpdate.class) RoomDto roomDto);

}
