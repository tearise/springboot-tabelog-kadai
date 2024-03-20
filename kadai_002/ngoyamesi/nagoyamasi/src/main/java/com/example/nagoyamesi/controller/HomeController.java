package com.example.nagoyamesi.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.nagoyamesi.entity.Restaurant;
import com.example.nagoyamesi.repository.RestaurantRepository;



@Controller
public class HomeController {
      private final RestaurantRepository RestaurantRepository;        
     
      public HomeController(RestaurantRepository RestaurantRepository) {
         this.RestaurantRepository = RestaurantRepository;            
     } 
	
	@GetMapping("/")
	public String index(Model model) {
	         List<Restaurant> newRestaurants = RestaurantRepository.findTop10ByOrderByCreatedAtDesc();
	         model.addAttribute("newRestaurants", newRestaurants);  	
		
		return "index";
	}
}
