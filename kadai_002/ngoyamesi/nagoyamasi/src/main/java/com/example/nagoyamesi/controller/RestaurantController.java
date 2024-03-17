package com.example.nagoyamesi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nagoyamesi.entity.Restaurant;
import com.example.nagoyamesi.repository.RestaurantRepository;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
	private final RestaurantRepository restaurantRepository;        
    
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;            
    }     
  
    //の部分は後からカテゴリの検索を作成
    @GetMapping
    public String index(@RequestParam(name = "keyword", required = false) String keyword,
                        @RequestParam(name = "area", required = false) String area,
                       // @RequestParam(name = "price", required = false) Integer price,                        
                        @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
                        Model model) 
    {
        Page<Restaurant> restaurantPage;
                
        if (keyword != null && !keyword.isEmpty()) {
        	restaurantPage = restaurantRepository.findByNameLikeOrAddressLike("%" + keyword + "%", "%" + keyword + "%", pageable);
        } else if (area != null && !area.isEmpty()) {
        	restaurantPage = restaurantRepository.findByAddressLike("%" + area + "%", pageable);
        //} else if (price != null) {
        	//restaurantPage = restaurantRepository.findByPri
        } else {
        	restaurantPage = restaurantRepository.findAll(pageable);
        }                
        
        model.addAttribute("restaurantPage", restaurantPage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("area", area);
        //model.addAttribute("price", price);                              
        
        return "restaurants/index";
    }
}
