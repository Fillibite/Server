package com.example.hackathon.domain.cart.repository;

import com.example.hackathon.domain.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
