package com.example.hackathon.domain.item.repository;

import com.example.hackathon.domain.item.entity.Item;
import com.example.hackathon.domain.item.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository  extends JpaRepository<Item, Long> {
    Optional<Item> findByItemName(String itemName);
    List<Item> findByItemType(Type itemType);
    List<Item> findByItemNameContaining(String keyword);
}
