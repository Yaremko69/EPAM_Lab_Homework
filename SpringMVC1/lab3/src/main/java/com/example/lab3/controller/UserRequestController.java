package com.example.lab3.controller;

import com.example.lab3.dto.UserRequestDto;
import com.example.lab3.service.UserRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRequestController {

    private final UserRequestService userRequestService;

    /*
    - Under development

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user_requests/{id}")
    public UserRequestDto getUserRequest(long id){return null;}
     */

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user_requests/{email}")
    public List<UserRequestDto> getUserRequests(@PathVariable String email) {
        return userRequestService.getUserRequests(email);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/user_Requests/{email}")
    public UserRequestDto updateUserRequest(@PathVariable String email
            , @RequestBody UserRequestDto userRequestDto) {
        return userRequestService.updateUserRequest(email, userRequestDto);
    }
}
