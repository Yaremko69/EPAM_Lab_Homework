package com.example.lab5.controller.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.lab5.controller.UserRequestController;
import com.example.lab5.controller.model.UserRequestModel;
import com.example.lab5.dto.UserRequestDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class UserRequestAssembler extends RepresentationModelAssemblerSupport<UserRequestDto, UserRequestModel> {

    public static final String GET_USER_REQUESTS = "get_user_requests";
    public static final String CREATE_USER_REQUEST = "create_user_request";
    public static final String UPDATE_USER_REQUEST = "update_user_request";

    public UserRequestAssembler(){
        super(UserRequestController.class, UserRequestModel.class);
    }

    @Override
    public UserRequestModel toModel(UserRequestDto entity) {
        UserRequestModel userRequestModel = new UserRequestModel(entity);

        Link getUserRequests = linkTo(methodOn(UserRequestController.class)
                .getUserRequests(entity.getUserEmail())).withRel(GET_USER_REQUESTS);
        Link create = linkTo(methodOn(UserRequestController.class)
                .createUserRequest(entity)).withRel(CREATE_USER_REQUEST);
        Link update = linkTo(methodOn(UserRequestController.class)
                .updateUserRequest(entity.getId(), entity)).withRel(UPDATE_USER_REQUEST);

        return userRequestModel.add(getUserRequests, create, update);
    }
}
