package com.example.lab3.service;

import com.example.lab3.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto getRoom(int roomNumber);

    List<RoomDto> getAllRooms();

    RoomDto createRoom(RoomDto roomDto);

    RoomDto updateRoom(int number, RoomDto roomDto);
}
