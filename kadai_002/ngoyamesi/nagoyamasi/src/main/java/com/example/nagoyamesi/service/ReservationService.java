package com.example.nagoyamesi.service;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	//取得した時間より2時間以上の空きがあるか比べる
	 public boolean okTime(LocalDatelTime reservationTime ) {
		 LocalTime now  = LocalTime.now();  // 現在の時間を取得
		    
		 LocalTime twoHoursLater = now.plusHours(2);   //2時間プラス
		 
		 long timeCompare = Math.abs(ChronoUnit.HOURS.between(reservationTime, twoHoursLater)): 予約時間と現在の時間を2時間プラスしたものを比べる
		 return timeCompare     
     }
     
}	