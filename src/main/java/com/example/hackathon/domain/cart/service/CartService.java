package com.example.hackathon.domain.cart.service;

import com.example.hackathon.domain.cart.dto.CartRequestDTO;
import com.example.hackathon.domain.cart.dto.CartResponseDTO;

public interface CartService {
    CartResponseDTO.CartFindAllDTO cartFindAll(String userEmail);
    CartResponseDTO.CartSelectAllDTO cartSelectAll(String userEmail, CartRequestDTO.CartSelectAllDTO cartSelectAllDTO);
}
