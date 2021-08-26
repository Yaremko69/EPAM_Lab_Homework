package com.example.lab5.service.imp;

import com.example.lab5.dto.UserRequestDto;
import com.example.lab5.model.Room;
import com.example.lab5.model.UserRequest;
import com.example.lab5.repository.UserRequestRepository;
import com.example.lab5.service.UserRequestService;
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
    public UserRequestDto createUserRequest(UserRequestDto userRequestDto) {
        log.info("createUserRequest with email {}", userRequestDto.getUserEmail());
        UserRequest userRequest = mapUserRequestDtoToUserRequest(userRequestDto);
        userRequest = userRequestRepository.createUserRequest(userRequest);
        return mapUserRequestToUserRequestDto(userRequest);
    }

    @Override
    public UserRequestDto updateUserRequest(long id, UserRequestDto userRequestDto) {
        log.info("updateUserRequest, user's email is {}", userRequestDto.getUserEmail());
        UserRequest userRequest = mapUserRequestDtoToUserRequest(userRequestDto);

        UserRequest oldUserRequest = userRequestRepository.getUserRequest(id);
        oldUserRequest.setStatus(userRequest.getStatus());

        userRequest = userRequestRepository.updateUserRequest(id, oldUserRequest);
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
                .status(userRequest.getStatus())
                .build();
    }

    private UserRequest mapUserRequestDtoToUserRequest(UserRequestDto userRequestDto){
        return UserRequest.builder()
                .userEmail(userRequestDto.getUserEmail())
                .roomClass(userRequestDto.getRoomClass())
                .size(userRequestDto.getSize())
                .dateFrom(userRequestDto.getDateFrom())
                .dateTo(userRequestDto.getDateTo())
                .status(userRequestDto.getStatus())
                .build();
    }
}
