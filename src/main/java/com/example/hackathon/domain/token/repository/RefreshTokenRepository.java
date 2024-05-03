package com.example.hackathon.domain.token.repository;


import com.example.hackathon.domain.token.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
