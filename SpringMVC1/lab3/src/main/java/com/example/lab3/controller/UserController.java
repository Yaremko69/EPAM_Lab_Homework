package com.example.lab3.controller;

import com.example.lab3.dto.UserDto;
import com.example.lab3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/users/{email}")
    public UserDto getUser(String email) {
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user")
    public UserDto creteUser(@RequestBody UserDto userDto) {
        return userService.creteUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/users/{email}")
    public UserDto updateUser(@PathVariable String email,@RequestBody UserDto userDto) {
        return userService.updateUser(email, userDto);
    }
}
