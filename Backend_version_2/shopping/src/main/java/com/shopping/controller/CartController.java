package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.dto.CartDTO;
import com.shopping.services.CartService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("user/{id}")
	public List<CartDTO> getById(@PathVariable(value = "id") long id) {
		return cartService.findByUserId(id);
	}

}
