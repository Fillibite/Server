package com.example.hackathon.domain.token.service;


import com.example.hackathon.domain.token.dto.RefreshTokenRequestDTO;
import com.example.hackathon.domain.token.dto.RefreshTokenResponseDTO;

public interface RefreshTokenService {
    RefreshTokenResponseDTO.RefreshTokenGetAccessTokenDTO getAccessToken(RefreshTokenRequestDTO.RefreshTokenGetAccessTokenDTO tokenGetAccessTokenDTO);
}
