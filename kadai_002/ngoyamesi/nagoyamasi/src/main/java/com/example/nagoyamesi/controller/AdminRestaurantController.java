package com.example.nagoyamesi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyamesi.entity.Restaurant;
import com.example.nagoyamesi.form.RestaurantEditForm;
import com.example.nagoyamesi.form.RestaurantRegisterForm;
import com.example.nagoyamesi.repository.RestaurantRepository;
import com.example.nagoyamesi.service.RestaurantService;

@Controller
@RequestMapping("/admin/restaurants")
/**
 * 店舗一覧表示
 * @author yuta2
 *
 */
public class AdminRestaurantController {
	private final RestaurantRepository restaurantRepository;
	private final RestaurantService restaurantService;
	
	public AdminRestaurantController(RestaurantRepository restaurantRepository, RestaurantService restaurantService) {
		this.restaurantRepository = restaurantRepository;
		this.restaurantService = restaurantService;
	}
	
	/**
	 *店舗を取得して返す 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String index(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, @RequestParam(name = "keyword",required = false) String keyword) {
		Page<Restaurant> restaurantPage;
		
		 if (keyword != null && !keyword.isEmpty()) {
			 restaurantPage = restaurantRepository.findByNameLike("%" + keyword + "%", pageable);                
         } else {
        	 restaurantPage = restaurantRepository.findAll(pageable);
         }  
		
		model.addAttribute("restaurantPage",restaurantPage);
		 model.addAttribute("keyword", keyword);
		return "admin/restaurants/index";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable(name = "id") Integer id, Model model) {
		Restaurant restaurant = restaurantRepository.getReferenceById(id);
		
		model.addAttribute("restaurant", restaurant);
		
		return "admin/restaurants/show";
	}
	
	 @GetMapping("/register")
     public String register(Model model) {
         model.addAttribute("restaurantRegisterForm", new RestaurantRegisterForm());
         return "admin/restaurants/register";
     }
	 @PostMapping("/create")
     public String create(@ModelAttribute @Validated RestaurantRegisterForm restaurantRegisterForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {        
         if (bindingResult.hasErrors()) {
             return "admin/restaurants/register";
         }
         
         restaurantService.create(restaurantRegisterForm);
         redirectAttributes.addFlashAttribute("successMessage", "店舗を登録しました。");    
         
         return "redirect:/admin/restaurants";
     }   
	 
	 @GetMapping("/{id}/edit")
     public String edit(@PathVariable(name = "id") Integer id, Model model) {
         Restaurant restaurant = restaurantRepository.getReferenceById(id);
         String imageName = restaurant.getImageName();
         RestaurantEditForm restaurantEditForm = new RestaurantEditForm(restaurant.getId(), null, restaurant.getName(),  restaurant.getDescription(), restaurant.getOpeningHours(), restaurant.getRegularClosing(), restaurant.getAddress(), restaurant.getTelephoneNumber());
         
         model.addAttribute("imageName", imageName);
         model.addAttribute("restaurantEditForm", restaurantEditForm);
         
         return "admin/restaurants/edit";
     } 
	 //更新
	 @PostMapping("/{id}/update")
     public String update(@ModelAttribute @Validated RestaurantEditForm restaurantEditForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {        
         if (bindingResult.hasErrors()) {
             return "admin/restaurants/edit";
         }
         
         restaurantService.update(restaurantEditForm);
         redirectAttributes.addFlashAttribute("successMessage", "民宿情報を編集しました。");
         
         return "redirect:/admin/restaurants";
     }
	 //削除
	 @PostMapping("/{id}/delete")
     public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {        
         restaurantRepository.deleteById(id);
                 
         redirectAttributes.addFlashAttribute("successMessage", "民宿を削除しました。");
         
         return "redirect:/admin/restaurants";
     }
}
