package com.example.lab3.repository;

import com.example.lab3.model.Room;

import java.util.List;

public interface RoomRepository {

    Room getRoom(int roomNumber);

    List<Room> getAllRooms();

    Room createRoom(Room room);

    Room updateRoom(int roomNumber, Room room);
}
