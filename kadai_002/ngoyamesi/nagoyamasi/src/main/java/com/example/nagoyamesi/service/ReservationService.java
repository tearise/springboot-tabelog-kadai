package com.example.nagoyamesi.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	//取得した時間より2時間以上の空きがあるか比べる
	 public boolean okTime(LocalTime reservationTime ) {
		 LocalTime now  = LocalTime.now();  // 現在の時間を取得
		    
		 LocalTime twoHoursLater = now.plusHours(2);   //2時間プラス
		 
		 return  reservationTime >= twoHoursLater;   //取得した予約時間と現在の時間に2時間したものより低いならok
     }
     
}	