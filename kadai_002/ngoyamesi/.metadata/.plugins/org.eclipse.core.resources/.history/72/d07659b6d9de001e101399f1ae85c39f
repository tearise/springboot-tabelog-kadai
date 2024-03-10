package com.example.nagoyamesi.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.nagoyamesi.entity.Restaurant;
import com.example.nagoyamesi.form.RestaurantRegisterForm;
import com.example.nagoyamesi.repository.RestaurantRepository;

@Service
public class RestaurantService {
	     private final RestaurantRepository restaurantRepository;    
	     
	     public RestaurantService(RestaurantRepository restaurantRepository) {
	         this.restaurantRepository = restaurantRepository;        
	     }    
	     
	     @Transactional
	     public void create(RestaurantRegisterForm restaurantRegisterForm) {
	         Restaurant restaurant = new Restaurant();        
	         MultipartFile imageFile = restaurantRegisterForm.getImageFile();
	         
	         if (!imageFile.isEmpty()) {
	             String imageName = imageFile.getOriginalFilename(); 
	             String hashedImageName = generateNewFileName(imageName);
	             Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
	             copyImageFile(imageFile, filePath);
	             restaurant.setImageName(hashedImageName);
	         }
	         
	         restaurant.setName(restaurantRegisterForm.getName());                
	         restaurant.setDescription(restaurantRegisterForm.getDescription());
	         restaurant.setOpeningHours(restaurantRegisterForm.getOpeningHours());
	         restaurant.setRegularClosing(restaurantRegisterForm.getRegularClosing());
	         restaurant.setAddress(restaurantRegisterForm.getAddress());
	         restaurant.setTelephoneNumber(restaurantRegisterForm.getTelephoneNumber());
	       //restaurant.setPhoneNumber(restaurantRegisterForm.getPhoneNumber());
	                     
	         restaurantRepository.save(restaurant);
	     }  
	     
	     // UUIDを使って生成したファイル名を返す
	     public String generateNewFileName(String fileName) {
	         String[] fileNames = fileName.split("\\.");                
	         for (int i = 0; i < fileNames.length - 1; i++) {
	             fileNames[i] = UUID.randomUUID().toString();            
	         }
	         String hashedFileName = String.join(".", fileNames);
	         return hashedFileName;
	     }     
	     
	     // 画像ファイルを指定したファイルにコピーする
	     public void copyImageFile(MultipartFile imageFile, Path filePath) {           
	         try {
	             Files.copy(imageFile.getInputStream(), filePath);
	         } catch (IOException e) {
	             e.printStackTrace();
	         }          
	     } 
}
