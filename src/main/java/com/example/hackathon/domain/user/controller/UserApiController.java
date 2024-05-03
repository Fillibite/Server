package com.example.hackathon.domain.user.controller;

import com.example.hackathon.domain.user.dto.UserRequestDTO;
import com.example.hackathon.domain.user.dto.UserResponseDTO;
import com.example.hackathon.domain.user.service.UserServiceImpl;
import com.example.hackathon.global.auth.service.AuthenticationService;
import com.example.hackathon.global.common.exception.Exception500;
import com.example.hackathon.global.common.reponse.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserApiController {
    private final UserServiceImpl userService;
    private final AuthenticationService authenticationService;

    // 회원 가입
    @PostMapping("/api/v1/member/user/join")
    public ResponseEntity<?> join(@RequestBody UserRequestDTO.UserJoinDTO userJoinDTO) {
        try {
            log.info("[UserApiController] join");
            UserResponseDTO.UserJoinDTO result = userService.join(userJoinDTO);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] UserApiController join", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] UserApiController join");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    // 로그인
    @PostMapping("/login/oauth2/code/kakao/{provider}")
    public ResponseEntity<?> login(@RequestBody UserRequestDTO.UserLoginDTO userLoginDTO) {
        try {
            log.info("[UserApiController] join");
            UserResponseDTO.UserLoginDTO result = new UserResponseDTO.UserLoginDTO();
            result.setAccessToken(userLoginDTO.getAccessToken());
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] UserApiController join", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] UserApiController join");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }
}
