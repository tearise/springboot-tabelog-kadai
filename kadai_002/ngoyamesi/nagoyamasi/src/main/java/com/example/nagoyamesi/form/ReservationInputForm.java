package com.example.nagoyamesi.form;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReservationInputForm {
	 @NotBlank(message = "予約日を選択してください。")
     private String fromReservationDayDate;  
	 
	 @NotBlank(message = "予約時間を選択してください。" )
	 private String fromReservationTime;
     
     @NotNull(message = "人数を入力してください。")
     @Min(value = 1, message = "人数は1人以上に設定してください。")
     private Integer numberOfPeople; 
 
     // 予約日を取得する
     public LocalDate getReservationDayDate() {
         String reservationDayDate = getFromReservationDayDate();
         return LocalDate.parse(reservationDayDate);
     }
 
     // 予約時間を選択してください。
     public LocalTime getReservationTime() {
    	 String reservationTime = getFromReservationTime();
    	 return LocalTime.parse(reservationTime);
     }
    
}
