package com.example.nagoyamesi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyamesi.entity.Reservation;
import com.example.nagoyamesi.entity.User;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    // カスタムのクエリメソッドがあればここに追加できる
	 public Page<Reservation> findByUserOrderByCreatedAtDesc(User user, Pageable pageable);

}
