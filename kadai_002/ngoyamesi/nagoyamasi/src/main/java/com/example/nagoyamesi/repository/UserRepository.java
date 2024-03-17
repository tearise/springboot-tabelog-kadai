package com.example.nagoyamesi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyamesi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    // カスタムのクエリメソッドがあればここに追加できる
	public User findByEmailAddress(String emailAddress);
	public Page<User> findByNameLikeOrFuriganaLike(String nameKeyword, String furiganaKeyword, Pageable pageable);
	

}
