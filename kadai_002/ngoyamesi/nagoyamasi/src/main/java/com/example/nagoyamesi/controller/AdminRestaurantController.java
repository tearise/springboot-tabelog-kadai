package com.example.nagoyamesi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.nagoyamesi.entity.Restaurant;
import com.example.nagoyamesi.repository.RestaurantRepository;

@Controller
@RequestMapping("/admin/restaurants")
/**
 * 店舗一覧表示
 * @author yuta2
 *
 */
public class AdminRestaurantController {
	private final RestaurantRepository restaurantRepository;
	
	public AdminRestaurantController(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}
	
	/**
	 *店舗を取得して返す 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String index(Model model) {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		
		model.addAttribute("restaurants",restaurants);
		
		return "admin/restaurants/index";
	}
}
