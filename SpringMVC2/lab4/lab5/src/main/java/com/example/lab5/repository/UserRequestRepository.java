package com.example.lab5.repository;

import com.example.lab5.model.UserRequest;

import java.util.List;

public interface UserRequestRepository {

    UserRequest getUserRequest(long id);

    List<UserRequest> getUserRequests(String email);

    UserRequest createUserRequest(UserRequest userRequest);

    UserRequest updateUserRequest(long id, UserRequest userRequest);
}
