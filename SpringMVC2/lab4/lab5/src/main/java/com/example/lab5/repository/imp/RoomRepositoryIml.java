package com.example.lab5.repository.imp;

import com.example.lab5.model.Room;
import com.example.lab5.repository.RoomRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomRepositoryIml implements RoomRepository {

    private final List<Room> list = new ArrayList<>();

    @Override
    public Room getRoom(int roomNumber) {
        return null;
    }

    @Override
    public List<Room> getAllRooms() {
        if (list.isEmpty()) {
            throw new RuntimeException("No rooms!");
        }
        return list;
    }

    @Override
    public Room createRoom(Room room) {
        list.add(room);
        return room;
    }

    @Override
    public Room updateRoom(int roomNumber, Room room) {
        boolean isDeleted = list.removeIf(r -> r.getRoomNumber() == roomNumber);
        if (isDeleted){
            list.add(room);
        } else {
            throw new RuntimeException("Room is not found!");
        }
        return room;
    }
}
