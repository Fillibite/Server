package com.example.hackathon.domain.item.controller;

import com.example.hackathon.domain.item.dto.ItemRequestDTO;
import com.example.hackathon.domain.item.dto.ItemResponseDTO;
import com.example.hackathon.domain.item.service.ItemServiceImpl;
import com.example.hackathon.domain.user.dto.UserRequestDTO;
import com.example.hackathon.domain.user.dto.UserResponseDTO;
import com.example.hackathon.domain.user.entity.User;
import com.example.hackathon.global.auth.service.AuthenticationService;
import com.example.hackathon.global.common.exception.Exception500;
import com.example.hackathon.global.common.reponse.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/member/item")
public class ItemApiController {
    private final ItemServiceImpl itemService;
    private final AuthenticationService authenticationService;

    // 샘플 아이템 조회
    @GetMapping("/sampleFindAll")
    public ResponseEntity<?> sampleFindAll() {
        try {
            log.info("[ItemApiController] sampleFindAll");
            String userEmail = getUserEmail();
            ItemResponseDTO.SampleItemFindAllDTO result = itemService.sampleItemFindAll();
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] ItemApiController sampleFindAll", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] ItemApiController sampleFindAll");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    // 패키지 아이템 조회
    @GetMapping("/packageFindAll")
    public ResponseEntity<?> packageFindAll() {
        try {
            log.info("[ItemApiController] packageFindAll");
            String userEmail = getUserEmail();
            ItemResponseDTO.PackageItemFindAllDTO result = itemService.packageItemFindAll();
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] ItemApiController packageFindAll", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] ItemApiController packageFindAll");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    // 샘플 아이템 조회
    @GetMapping("/findOne/{itemId}")
    public ResponseEntity<?> findOne(@PathVariable("itemId") Long itemId) {
        try {
            log.info("[CartApiController] findOne");
            String userEmail = getUserEmail();
            ItemResponseDTO.ItemFindOneDTO result = itemService.findOne(itemId);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] ItemApiController findOne", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] CartApiController findOne");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }


    // 검색 아이템 조회
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestBody ItemRequestDTO.ItemSearchDTO itemSearchDTO) {
        try {
            log.info("[CartApiController] findOne");
            String userEmail = getUserEmail();
            ItemResponseDTO.ItemSearch result = itemService.searchKeyWord(itemSearchDTO);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] ItemApiController search", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] CartApiController findOne");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    private String getUserEmail() {
        User user = authenticationService.getCurrentAuthenticatedUser();
        String userEmail = user.getUserEmail();
        return userEmail;
    }
}
