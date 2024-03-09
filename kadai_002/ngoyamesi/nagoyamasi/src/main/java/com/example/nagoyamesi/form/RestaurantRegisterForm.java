package com.example.nagoyamesi.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RestaurantRegisterForm {
	 private MultipartFile imageFile;
	
	 @NotBlank(message = "店舗名を入力してください。")
     private String name;
     
     @NotBlank(message = "説明を入力してください。")
     private String description;   
     
     @NotBlank(message = "営業時間を入力してください。")
     private String openingHours;
     
     @NotBlank(message = "定休日を入力してください。")
     private String regularClosing;
     
     @NotBlank(message = "住所を入力してください。")
     private String address;
     
     @NotBlank(message = "電話番号を入力してください。")
     private String telephoneNumber;
	
	
}