package com.example.lab5.controller;

import com.example.lab5.api.UserApi;
import com.example.lab5.controller.assembler.UserAssembler;
import com.example.lab5.controller.model.UserModel;
import com.example.lab5.dto.UserDto;
import com.example.lab5.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    private final UserAssembler userAssembler;

    @Override
    public UserModel getUser(String email) {
        UserDto user = userService.getUser(email);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel creteUser(UserDto userDto) {
        UserDto user = userService.creteUser(userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel updateUser(String email, UserDto userDto) {
        UserDto user = userService.updateUser(email, userDto);
        return userAssembler.toModel(user);
    }
}
