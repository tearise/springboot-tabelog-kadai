package com.example.nagoyamesi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyamesi.entity.Reservation;
import com.example.nagoyamesi.entity.Restaurant;
import com.example.nagoyamesi.entity.User;
import com.example.nagoyamesi.form.ReservationInputForm;
import com.example.nagoyamesi.repository.ReservationRepository;
import com.example.nagoyamesi.repository.RestaurantRepository;
import com.example.nagoyamesi.security.UserDetailsImpl;
import com.example.nagoyamesi.service.ReservationService;

@Controller
public class ReservationController {
	  private final ReservationRepository reservationRepository;
	  private final RestaurantRepository restaurantRepository;
	  private final ReservationService reservationService; 
	     
	     public ReservationController(ReservationRepository reservationRepository, RestaurantRepository restaurantRepository,ReservationService reservationService) {        
	         this.reservationRepository = reservationRepository;       
	         this.restaurantRepository = restaurantRepository;
	         this.reservationService =  reservationService;
	     }    
	 
	     @GetMapping("/reservations")
	     public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, Model model) {
	         User user = userDetailsImpl.getUser();
	         Page<Reservation> reservationPage = reservationRepository.findByUserOrderByCreatedAtDesc(user, pageable);
	         
	         model.addAttribute("reservationPage", reservationPage);         
	         
	         return "reservations/index";
	     }
	     
	     @GetMapping("/restaurants/{id}/reservations/input")
	     public String input(@PathVariable(name = "id") Integer id,
	                         @ModelAttribute @Validated ReservationInputForm reservationInputForm,
	                         BindingResult bindingResult,
	                         RedirectAttributes redirectAttributes,
	                         Model model)
	     {   
	    	 Restaurant restaurant = restaurantRepository.getReferenceById(id);
	         Integer numberOfPeople = reservationInputForm.getNumberOfPeople();   
	         
	         
	         
	         if (bindingResult.hasErrors()) {            
	             model.addAttribute("restaurant", restaurant);            
	             model.addAttribute("errorMessage", "予約内容に不備があります。"); 
	             return "restaurants/show";
	         }
	         
	         redirectAttributes.addFlashAttribute("reservationInputForm", reservationInputForm);           
	         
	         return "redirect:/restaurants/{id}/reservations/confirm";
	     }    
}
