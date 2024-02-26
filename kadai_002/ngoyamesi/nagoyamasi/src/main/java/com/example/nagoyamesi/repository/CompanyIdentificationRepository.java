package com.example.nagoyamesi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyamesi.entity.CompanyIdentification;

public interface CompanyIdentificationRepository extends JpaRepository<CompanyIdentification, Integer> {
    // カスタムのクエリメソッドがあればここに追加できる
}
