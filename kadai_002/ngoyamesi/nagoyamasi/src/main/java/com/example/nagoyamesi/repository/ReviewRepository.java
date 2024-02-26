package com.example.nagoyamesi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyamesi.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    // カスタムのクエリメソッドがあればここに追加できる
}
