package com.example.lab5.api;

import com.example.lab5.controller.model.UserModel;
import com.example.lab5.dto.UserDto;
import com.example.lab5.dto.group.OnCreate;
import com.example.lab5.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "User management API")
@RequestMapping("/api/v1/users")
public interface UserApi {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    UserModel getUser(@PathVariable String email);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserModel creteUser(@RequestBody @Validated(OnCreate.class) UserDto userDto);

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}")
    UserModel updateUser(@PathVariable String email, @RequestBody @Validated(OnUpdate.class) UserDto userDto);
}
