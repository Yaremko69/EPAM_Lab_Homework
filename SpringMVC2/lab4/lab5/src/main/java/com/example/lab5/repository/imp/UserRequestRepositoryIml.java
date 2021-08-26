package com.example.lab5.repository.imp;

import com.example.lab5.model.UserRequest;
import com.example.lab5.repository.UserRequestRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRequestRepositoryIml implements UserRequestRepository {

    private final List<UserRequest> list = new ArrayList<>();

    @Override
    public UserRequest getUserRequest(long id) {
        return list.stream()
                .filter(userRequest -> userRequest.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User's requet is not found"));
    }

    @Override
    public List<UserRequest> getUserRequests(String email) {
        return list;
    }

    @Override
    public UserRequest createUserRequest(UserRequest userRequest) {
        list.add(userRequest);
        return userRequest;
    }

    @Override
    public UserRequest updateUserRequest(long id, UserRequest userRequest) {
            boolean isDeleted = list.removeIf(ur -> ur.getId() == id);
            if(isDeleted){
                list.add(userRequest);
            } else {
                throw new RuntimeException("User's request is not found!");
            }
            return userRequest;
    }

}
