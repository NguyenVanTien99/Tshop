package com.shopping.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.converter.CartConverter;
import com.shopping.dto.CartDTO;
import com.shopping.entities.Cart;
import com.shopping.repository.CartRepository;
import com.shopping.services.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	CartConverter cartConverter;

	@Override
	public List<CartDTO> findByUserId(Long id) {

		List<Cart> carts = cartRepository.findByUserId(id);

		List<CartDTO> cartDTOs = new ArrayList<CartDTO>();

		for (Cart cart : carts) {
			
			cartDTOs.add(cartConverter.toDTO(cart));
		}
		

		return cartDTOs;
	}

}
