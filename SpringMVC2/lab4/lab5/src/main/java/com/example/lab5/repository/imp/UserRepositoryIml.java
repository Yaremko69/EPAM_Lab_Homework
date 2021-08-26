package com.example.lab5.repository.imp;

import com.example.lab5.exeption.UserNotFoundException;
import com.example.lab5.model.User;
import com.example.lab5.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryIml implements UserRepository {

    private final List<User> list = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return list;
    }

    @Override
    public User getUser(String email) {
        return list.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException());

    }

    @Override
    public User creteUser(User user) {
        list.add(user);
        return user;
    }

    @Override
    public User updateUser(String email,User user) {
        boolean isDeleted = list.removeIf(u -> u.getEmail().equals(email));
        if(isDeleted){
            list.add(user);
        } else {
            throw new UserNotFoundException();
        }
        return user;
    }
}
