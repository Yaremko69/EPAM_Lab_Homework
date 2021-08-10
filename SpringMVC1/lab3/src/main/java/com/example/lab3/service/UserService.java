package com.example.lab3.service;

import com.example.lab3.dto.UserDto;

public interface UserService {

    UserDto getUser(String email);

    UserDto creteUser(UserDto userDto);

    UserDto updateUser(String email, UserDto userDto);
}
