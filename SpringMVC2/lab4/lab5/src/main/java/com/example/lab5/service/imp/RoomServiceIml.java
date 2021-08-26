package com.example.lab5.service.imp;

import com.example.lab5.dto.RoomDto;
import com.example.lab5.model.Room;
import com.example.lab5.repository.RoomRepository;
import com.example.lab5.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomServiceIml implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public RoomDto getRoom(int roomNumber) {
        log.info("getRoom by number {}", roomNumber);
        Room room = roomRepository.getRoom(roomNumber);
        return mapRoomToRoomDto(room);
    }

    @Override
    public List<RoomDto> getAllRooms() {
        log.info("getAllRooms");
        List<RoomDto> listDto = new ArrayList<>();
        for (Room room : roomRepository.getAllRooms()){
            listDto.add(mapRoomToRoomDto(room));
        }
        return listDto;
    }

    @Override
    public RoomDto createRoom(RoomDto roomDto) {
        log.info("createRoom with number {}", roomDto.getRoomNumber());
        Room room = mapRoomDtoToRoom(roomDto);
        room = roomRepository.createRoom(room);
        return mapRoomToRoomDto(room);
    }

    @Override
    public RoomDto updateRoom(int roomNumber, RoomDto roomDto) {
        log.info("updateRoom with number {}", roomDto.getRoomNumber());
        Room room = mapRoomDtoToRoom(roomDto);

        Room oldRoom = roomRepository.getRoom(roomNumber);
        room.setRoomNumber(oldRoom.getRoomNumber());

        room = roomRepository.updateRoom(roomNumber, room);
        return mapRoomToRoomDto(room);
    }

    private RoomDto mapRoomToRoomDto(Room room){
        return RoomDto.builder()
                .roomNumber(room.getRoomNumber())
                .size(room.getSize())
                .roomClass(room.getRoomClass())
                .descriptionEng(room.getDescriptionEng())
                .descriptionUa(room.getDescriptionUa())
                .build();
    }

    private Room mapRoomDtoToRoom(RoomDto roomDto){
        return Room.builder()
                .roomNumber(roomDto.getRoomNumber())
                .size(roomDto.getSize())
                .roomClass(roomDto.getRoomClass())
                .descriptionEng(roomDto.getDescriptionEng())
                .descriptionUa(roomDto.getDescriptionUa())
                .build();
    }
}
