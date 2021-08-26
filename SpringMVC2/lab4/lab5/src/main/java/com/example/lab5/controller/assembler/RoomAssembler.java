package com.example.lab5.controller.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.lab5.controller.RoomController;
import com.example.lab5.controller.model.RoomModel;
import com.example.lab5.dto.RoomDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class RoomAssembler extends RepresentationModelAssemblerSupport<RoomDto, RoomModel> {

    public static final String GET_ROOM = "get_room";
    public static final String GET_ALL_ROOM = "get_all_room";
    public static final String CREATE_ROOM = "create_room";
    public static final String UPDATE_ROOM = "update_room";

    public RoomAssembler(){
        super(RoomController.class, RoomModel.class);
    }


    @Override
    public RoomModel toModel(RoomDto entity) {
        RoomModel roomModel = new RoomModel(entity);

        Link get = linkTo(methodOn(RoomController.class).getRoom(entity.getRoomNumber())).withRel(GET_ROOM);
        Link getAll = linkTo(methodOn(RoomController.class).getAllRooms()).withRel(GET_ALL_ROOM);
        Link create = linkTo(methodOn(RoomController.class).createRoom(entity)).withRel(CREATE_ROOM);
        Link update = linkTo(methodOn(RoomController.class).updateRoom(entity.getRoomNumber(), entity))
                .withRel(UPDATE_ROOM);

        return roomModel.add(get, getAll, create, update);
    }
}
