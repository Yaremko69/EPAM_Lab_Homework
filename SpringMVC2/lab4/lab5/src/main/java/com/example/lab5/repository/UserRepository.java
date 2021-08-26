package com.example.lab5.repository;

import com.example.lab5.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();

    User getUser(String email);

    User creteUser(User user);

    User updateUser(String email, User user);
}
