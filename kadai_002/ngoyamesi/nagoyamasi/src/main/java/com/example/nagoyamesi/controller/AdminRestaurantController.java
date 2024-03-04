package com.example.nagoyamesi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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
	public String index(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable ) {
		Page<Restaurant> restaurantsPage = restaurantRepository.findAll(pageable);
		
		model.addAttribute("restaurantsPage",restaurantsPage);
		
		return "admin/restaurants/index";
	}
}
