package com.example.lab3.service;

import com.example.lab3.dto.UserRequestDto;

import java.util.List;

public interface UserRequestService {

    UserRequestDto getUserRequest(long id);

    List<UserRequestDto> getUserRequests(String email);

    UserRequestDto updateUserRequest(String email, UserRequestDto userRequestDto);

}
