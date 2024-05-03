package com.example.hackathon.domain.order.controller;

import com.example.hackathon.domain.order.service.OrderService;
import com.example.hackathon.domain.user.dto.UserResponseDTO;
import com.example.hackathon.global.auth.service.AuthenticationService;
import com.example.hackathon.global.common.exception.Exception500;
import com.example.hackathon.global.common.reponse.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/member/orders")
public class OrderController {
    private final OrderService orderService;
    private final AuthenticationService authenticationService;

//    @GetMapping("/count")
//    public ResponseEntity<?> count(@PathVariable Long userId) {
//        try {
//            log.info("[UserApiController] join");
//            UserResponseDTO.UserJoinDTO result = userService.join(userJoinDTO);
//            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] UserApiController join", result));
//        }  catch (Exception500 e) {
//            log.info("[Exception500] UserApiController join");
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
//        }
//    }
}
