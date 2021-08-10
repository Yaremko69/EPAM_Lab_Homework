package com.example.lab3.controller;

import com.example.lab3.dto.RoomDto;
import com.example.lab3.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/rooms/{roomNumber}")
    public RoomDto getRoom(@PathVariable int roomNumber) {
        return roomService.getRoom(roomNumber);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/rooms")
    public List<RoomDto> getAllRooms() {
            return roomService.getAllRooms();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/rooms")
    public RoomDto createRoom(@RequestBody RoomDto roomDto) {
        return roomService.createRoom(roomDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/rooms/{roomNumber}")
    public RoomDto updateRoom(@PathVariable int roomNumber,@RequestBody RoomDto roomDto) {
        return roomService.updateRoom(roomNumber, roomDto);
    }
}
