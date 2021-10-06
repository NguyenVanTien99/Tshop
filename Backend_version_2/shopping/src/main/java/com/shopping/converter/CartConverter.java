package com.shopping.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.dto.CartDTO;
import com.shopping.dto.CartDetailDTO;
import com.shopping.entities.Cart;

@Component
public class CartConverter {
	
	
	@Autowired
	ModelMapper modelMapper;

	public Cart toEntity(CartDTO cartDTO) {

		Cart cart = modelMapper.map(cartDTO, Cart.class);

		return cart;

	}

	public CartDTO toDTO(Cart cart) {

		CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);
		
		for (CartDetailDTO item : cartDTO.getCartDetails()) {
			item.setCart(null);
		}

		return cartDTO;
	}

}
