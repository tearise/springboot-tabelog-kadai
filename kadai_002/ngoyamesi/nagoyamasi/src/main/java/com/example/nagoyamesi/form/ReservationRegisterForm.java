package com.example.nagoyamesi.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationRegisterForm {

	 private Integer restaurantId;
     
     private Integer userId;    
         
     private String reservationDay;    
         
     private String reservationTime;    
     
     private Integer reservationNumberPeople;
     
}
