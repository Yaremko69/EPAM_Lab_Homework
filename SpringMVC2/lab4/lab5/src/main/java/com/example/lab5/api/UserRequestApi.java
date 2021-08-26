package com.example.lab5.api;

import com.example.lab5.controller.model.UserRequestModel;
import com.example.lab5.dto.UserRequestDto;
import com.example.lab5.dto.group.OnCreate;
import com.example.lab5.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "User's request management API")
@RequestMapping("/api/v1/user_requests")
public interface UserRequestApi {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    List<UserRequestModel> getUserRequests(@PathVariable String email);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserRequestModel createUserRequest(@RequestBody @Validated(OnCreate.class) UserRequestDto userRequestDto);

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    UserRequestModel updateUserRequest(@PathVariable long id
            , @RequestBody @Validated(OnUpdate.class) UserRequestDto userRequestDto);

}
