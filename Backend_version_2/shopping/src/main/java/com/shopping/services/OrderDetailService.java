package com.shopping.services;

import java.util.List;

import com.shopping.dto.OrderDetailDTO;

public interface OrderDetailService {

	OrderDetailDTO save(OrderDetailDTO orderDetailDTO);
	
	List<OrderDetailDTO> getAllByOrderId(Long id);

}
