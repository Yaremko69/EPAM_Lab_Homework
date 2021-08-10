package com.example.lab3.repository;

import com.example.lab3.model.User;

public interface UserRepository {

    User getUser(String email);

    User creteUser(User user);

    User updateUser(String email, User user);
}
