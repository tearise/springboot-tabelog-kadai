package com.example.nagoyamesi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyamesi.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    // カスタムのクエリメソッドがあればここに追加できる
	public Page<Restaurant> findByNameLike(String keyword, Pageable pageable);
	
	 public Page<Restaurant> findByNameLikeOrAddressLike(String nameKeyword, String addressKeyword, Pageable pageable);    
     public Page<Restaurant> findByAddressLike(String area, Pageable pageable);
     //カテゴリの検索
     //public Page<Restaurant> findByNameLike(String category, Pageable pageable);
	 
	 public Page<Restaurant> findAllByOrderByCreatedAtDesc(Pageable pageable); 
	 
	 public List<Restaurant> findTop10ByOrderByCreatedAtDesc();
}
