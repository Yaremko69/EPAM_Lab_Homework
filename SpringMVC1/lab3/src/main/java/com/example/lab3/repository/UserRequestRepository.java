package com.example.lab3.repository;

import com.example.lab3.model.UserRequest;

import java.util.List;

public interface UserRequestRepository {

    UserRequest getUserRequest(long id);

    List<UserRequest> getUserRequests(String email);

    UserRequest updateUserRequest(String email, UserRequest userRequest);
}
