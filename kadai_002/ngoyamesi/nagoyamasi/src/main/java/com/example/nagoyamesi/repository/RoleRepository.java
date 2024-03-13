package com.example.nagoyamesi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyamesi.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    // カスタムのクエリメソッドがあればここに追加できる
	public Role findByName(String name);
}
