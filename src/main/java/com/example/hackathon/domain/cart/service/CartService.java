package com.example.hackathon.domain.cart.service;

import com.example.hackathon.domain.cart.dto.CartResponseDTO;

public interface CartService {
    CartResponseDTO.CartFindAllDTO cartFindAll(String userEmail);
}
