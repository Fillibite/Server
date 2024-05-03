package com.example.hackathon.domain.category.repository;

import com.example.hackathon.domain.category.entity.Category;
import com.example.hackathon.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
