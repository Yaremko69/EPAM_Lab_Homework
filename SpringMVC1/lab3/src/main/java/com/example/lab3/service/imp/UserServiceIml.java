package com.example.lab3.service.imp;

import com.example.lab3.dto.UserDto;
import com.example.lab3.model.User;
import com.example.lab3.repository.UserRepository;
import com.example.lab3.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceIml implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String email) {
        log.info("getUser by email {}", email);
        User user = userRepository.getUser(email);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto creteUser(UserDto userDto) {
        log.info("createUser with email {}", userDto.getEmail());
        User user = mapUserDtoToUser(userDto);
        user = userRepository.creteUser(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        log.info("updateUser with email {}", userDto.getEmail());
        User user = mapUserDtoToUser(userDto);
        user = userRepository.updateUser(email, user);
        return mapUserToUserDto(user);
    }

    private UserDto mapUserToUserDto(User user){
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    private User mapUserDtoToUser(UserDto userDto){
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}
