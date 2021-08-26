package com.example.lab5.controller;

import com.example.lab5.api.UserRequestApi;
import com.example.lab5.controller.assembler.UserRequestAssembler;
import com.example.lab5.controller.model.UserRequestModel;
import com.example.lab5.dto.UserRequestDto;
import com.example.lab5.service.UserRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRequestController implements UserRequestApi {

    private final UserRequestService userRequestService;

    private final UserRequestAssembler userRequestAssembler;

    /*
    - Under development

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user_requests/{id}")
    public UserRequestDto getUserRequest(long id){return null;}
     */

    // - Under development
    @Override
    public List<UserRequestModel> getUserRequests(String email) {
        List<UserRequestModel> list = new ArrayList<>();
        for (UserRequestDto userRequest: userRequestService.getUserRequests(email)){
            list.add(userRequestAssembler.toModel(userRequest));
        }
        return list;
    }

    @Override
    public UserRequestModel createUserRequest(UserRequestDto userRequestDto){
        UserRequestDto userRequest = userRequestService.createUserRequest(userRequestDto);
        return userRequestAssembler.toModel(userRequest);
    }

    @Override
    public UserRequestModel updateUserRequest(long id, UserRequestDto userRequestDto) {
        UserRequestDto userRequest = userRequestService.updateUserRequest(id, userRequestDto);
        return userRequestAssembler.toModel(userRequest);
    }
}
