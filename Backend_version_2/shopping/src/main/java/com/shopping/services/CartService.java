package com.shopping.services;

import java.util.List;

import com.shopping.dto.CartDTO;

public interface CartService {
	
	List<CartDTO> findByUserId(Long id);

}
