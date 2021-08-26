package com.example.lab5.service;

import com.example.lab5.dto.UserDto;

public interface UserService {

    public boolean isUserExist(String email);

    UserDto getUser(String email);

    UserDto creteUser(UserDto userDto);

    UserDto updateUser(String email, UserDto userDto);
}
