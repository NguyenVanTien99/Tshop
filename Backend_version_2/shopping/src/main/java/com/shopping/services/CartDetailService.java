package com.shopping.services;

import java.util.List;

import com.shopping.dto.CartDetailDTO;

public interface CartDetailService {
	
	CartDetailDTO save(CartDetailDTO cartDetailDTO);
	
	CartDetailDTO update(CartDetailDTO cartDetailDTO);
	
	void delete(Long id);
	
	List<CartDetailDTO> getByCartId(Long id);
	
	CartDetailDTO getById(Long id);

}
