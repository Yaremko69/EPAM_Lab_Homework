package com.example.lab5.service;

import com.example.lab5.dto.UserRequestDto;

import java.util.List;

public interface UserRequestService {

    UserRequestDto getUserRequest(long id);

    List<UserRequestDto> getUserRequests(String email);

    UserRequestDto createUserRequest(UserRequestDto userRequestDto);

    UserRequestDto updateUserRequest(long id, UserRequestDto userRequestDto);

}
