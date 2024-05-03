package com.example.hackathon.domain.cart.controller;

import com.example.hackathon.domain.cart.dto.CartResponseDTO;
import com.example.hackathon.domain.cart.service.CartServiceImpl;
import com.example.hackathon.domain.item.dto.ItemResponseDTO;
import com.example.hackathon.domain.user.entity.User;
import com.example.hackathon.global.auth.service.AuthenticationService;
import com.example.hackathon.global.common.exception.Exception500;
import com.example.hackathon.global.common.reponse.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/member/cart")
public class CartApiController {
    private final CartServiceImpl cartService;
    private final AuthenticationService authenticationService;

    // 샘플 아이템 조회
    @GetMapping("/cartFindAll")
    public ResponseEntity<?> cartFindAll() {
        try {
            log.info("[CartApiController] sampleFindAll");
            String userEmail = getUserEmail();
            CartResponseDTO.CartFindAllDTO result = cartService.cartFindAll(userEmail);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] CartApiController cartFindAll", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] CartApiController cartFindAll");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    private String getUserEmail() {
        User user = authenticationService.getCurrentAuthenticatedUser();
        String userEmail = user.getUserEmail();
        return userEmail;
    }
}
