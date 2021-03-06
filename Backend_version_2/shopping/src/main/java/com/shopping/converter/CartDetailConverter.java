package com.shopping.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.dto.CartDetailDTO;
import com.shopping.dto.RateDTO;
import com.shopping.entities.CartDetail;

@Component
public class CartDetailConverter {
	
	@Autowired
	ModelMapper modelMapper;
	
	
	public CartDetail toEntity(CartDetailDTO cartDetailDTO) {

		CartDetail cartDetail = modelMapper.map(cartDetailDTO, CartDetail.class);

		return cartDetail;

	}

	public CartDetailDTO toDTO(CartDetail cart) {

		CartDetailDTO cartDetailDTO = modelMapper.map(cart, CartDetailDTO.class);
		
		cartDetailDTO.getCart().setCartDetails(null);
		
//		for (RateDTO item : cartDetailDTO.getProduct().getRates()) {
//			item.setProduct(null);
//		}

		return cartDetailDTO;
	}


}
