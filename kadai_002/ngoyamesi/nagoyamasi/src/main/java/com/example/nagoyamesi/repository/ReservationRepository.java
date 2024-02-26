package com.example.nagoyamesi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyamesi.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    // カスタムのクエリメソッドがあればここに追加できる
}
