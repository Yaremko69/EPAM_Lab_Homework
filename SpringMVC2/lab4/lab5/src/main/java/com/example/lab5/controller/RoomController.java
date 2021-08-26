package com.example.lab5.controller;

import com.example.lab5.api.RoomApi;
import com.example.lab5.controller.assembler.RoomAssembler;
import com.example.lab5.controller.model.RoomModel;
import com.example.lab5.dto.RoomDto;
import com.example.lab5.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomController implements RoomApi {

    private final RoomService roomService;
    private final RoomAssembler roomAssembler;

    @Override
    public RoomModel getRoom(int roomNumber) {
        RoomDto roomDto = roomService.getRoom(roomNumber);
        return roomAssembler.toModel(roomDto);
    }

    // - Under development
    @Override
    public List<RoomModel> getAllRooms() {
        List<RoomModel> list = new ArrayList<>();
        for (RoomDto room: roomService.getAllRooms()){
            list.add(roomAssembler.toModel(room));
        }
        return list;
    }

    @Override
    public RoomModel createRoom(RoomDto roomDto) {
        RoomDto room = roomService.createRoom(roomDto);
        return roomAssembler.toModel(room);
    }

    @Override
    public RoomModel updateRoom(int roomNumber, RoomDto roomDto) {
        RoomDto room = roomService.updateRoom(roomNumber, roomDto);
        return roomAssembler.toModel(room);
    }
}
