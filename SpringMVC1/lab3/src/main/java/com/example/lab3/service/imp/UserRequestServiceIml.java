package com.example.lab3.service.imp;

import com.example.lab3.dto.UserRequestDto;
import com.example.lab3.model.UserRequest;
import com.example.lab3.repository.UserRequestRepository;
import com.example.lab3.service.UserRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRequestServiceIml implements UserRequestService {

    private final UserRequestRepository userRequestRepository;

    @Override
    public UserRequestDto getUserRequest(long id) {
        log.info("getUserRequest by id {}", id);
        UserRequest userRequest = userRequestRepository.getUserRequest(id);
        return mapUserRequestToUserRequestDto(userRequest);
    }

    @Override
    public List<UserRequestDto> getUserRequests(String email) {
        log.info("getUserRequest by user's email {}", email);
        List<UserRequestDto> listDto = new ArrayList<>();
        for (UserRequest userRequest : userRequestRepository.getUserRequests(email)){
            listDto.add(mapUserRequestToUserRequestDto(userRequest));
        }
        return listDto;
    }

    @Override
    public UserRequestDto updateUserRequest(String email, UserRequestDto userRequestDto) {
        log.info("updateUserRequest, user's email is {}", userRequestDto.getUserEmail());
        UserRequest userRequest = mapUserRequestDtoToUserRequest(userRequestDto);
        userRequest = userRequestRepository.updateUserRequest(email, userRequest);
        return mapUserRequestToUserRequestDto(userRequest);
    }


    private UserRequestDto mapUserRequestToUserRequestDto(UserRequest userRequest){
        return UserRequestDto.builder()
                .id(userRequest.getId())
                .userEmail(userRequest.getUserEmail())
                .roomClass(userRequest.getRoomClass())
                .size(userRequest.getSize())
                .dateFrom(userRequest.getDateFrom())
                .dateTo(userRequest.getDateTo())
                .requestDate(userRequest.getRequestDate())
                .build();
    }

    private UserRequest mapUserRequestDtoToUserRequest(UserRequestDto userRequestDto){
        return UserRequest.builder()
                .userEmail(userRequestDto.getUserEmail())
                .roomClass(userRequestDto.getRoomClass())
                .size(userRequestDto.getSize())
                .dateFrom(userRequestDto.getDateFrom())
                .dateTo(userRequestDto.getDateTo())
                .build();
    }
}
