package com.example.lab5.controller.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.lab5.controller.UserController;
import com.example.lab5.controller.model.UserModel;
import com.example.lab5.dto.UserDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {

    public static final String GET_REL = "get_user";
    public static final String CREATE_REL = "create_user";
    public static final String UPDATE_USER = "update_user";

    public UserAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto entity) {
        UserModel userModel = new UserModel(entity);

        Link get = linkTo(methodOn(UserController.class).getUser(entity.getEmail())).withRel(GET_REL);
        Link create = linkTo(methodOn(UserController.class).creteUser(entity)).withRel(CREATE_REL);
        Link update = linkTo(methodOn(UserController.class)
                .updateUser(entity.getEmail(), entity)).withRel(UPDATE_USER);

        return userModel.add(get, create, update);
    }
}
