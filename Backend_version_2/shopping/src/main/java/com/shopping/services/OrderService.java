package com.shopping.services;

import org.springframework.data.domain.Page;

import com.shopping.dto.OrderDTO;

public interface OrderService {

	OrderDTO save(OrderDTO orderDTO);
	
	OrderDTO update(OrderDTO orderDTO);

	Page<OrderDTO> getByUserId(Long id, Integer page, Integer size);
	
	OrderDTO getById(Long id);
	
	Page<OrderDTO> getAll(Integer page, Integer size);

}
