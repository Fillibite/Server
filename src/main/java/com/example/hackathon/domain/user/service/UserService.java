package com.example.hackathon.domain.user.service;

import com.example.hackathon.domain.user.dto.UserRequestDTO;
import com.example.hackathon.domain.user.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO.UserJoinDTO join(UserRequestDTO.UserJoinDTO userJoinDTO);
}
