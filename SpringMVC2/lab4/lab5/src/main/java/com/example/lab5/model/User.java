package com.example.lab5.model;

import com.example.lab5.model.enums.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserRole role;
}
