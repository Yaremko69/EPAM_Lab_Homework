package com.example.lab5.dto;

import com.example.lab5.dto.group.OnCreate;
import com.example.lab5.dto.group.OnUpdate;
import com.example.lab5.model.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class UserDto {

    @NotBlank(message = "'firstName' shouldn't be empty", groups = OnCreate.class)
    private String firstName;

    @NotBlank(message = "'lastName' shouldn't be empty", groups = OnCreate.class)
    private String lastName;

    @Email(message = "Please check if your email is correct")
    @Null(message = "'email' should be absent in request", groups = OnUpdate.class)
    @NotBlank(message = "'email' shouldn't be empty", groups = OnCreate.class)
    private String email;

    @Null(message = "'password' should be absent in request", groups = OnUpdate.class)
    @NotBlank(message = "'password' shouldn't be empty", groups = OnCreate.class)
    private String password;

    @Null(message = "'repeatPassword' should be absent in request", groups = OnUpdate.class)
    @NotBlank(message = "'repeatPassword' shouldn't be empty!", groups = OnCreate.class)
    private String repeatPassword;

    @Null(message = "'Role' should be absent in request", groups = {OnUpdate.class, OnCreate.class})
    private UserRole role;
}
