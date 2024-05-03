package com.example.hackathon.domain.item.repository;

import com.example.hackathon.domain.item.entity.Item;
import com.example.hackathon.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository  extends JpaRepository<Item, Long> {
}
