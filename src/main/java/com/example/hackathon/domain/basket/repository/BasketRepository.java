package com.example.hackathon.domain.basket.repository;

import com.example.hackathon.domain.basket.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
