package com.example.lab5.service;

import com.example.lab5.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto getRoom(int roomNumber);

    List<RoomDto> getAllRooms();

    RoomDto createRoom(RoomDto roomDto);

    RoomDto updateRoom(int number, RoomDto roomDto);
}
