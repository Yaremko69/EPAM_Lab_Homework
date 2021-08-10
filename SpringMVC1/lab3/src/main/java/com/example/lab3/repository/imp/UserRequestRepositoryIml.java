package com.example.lab3.repository.imp;

import com.example.lab3.model.User;
import com.example.lab3.model.UserRequest;
import com.example.lab3.repository.UserRequestRepository;
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
        if (list.isEmpty()) {
            throw new RuntimeException("No requests!");
        }
        return list;
    }

    @Override
    public UserRequest updateUserRequest(String email, UserRequest userRequest) {
            boolean isDeleted = list.removeIf(ur -> ur.getUserEmail().equals(email));
            if(isDeleted){
                list.add(userRequest);
            } else {
                throw new RuntimeException("User's request is not found!");
            }
            return userRequest;
    }

}
