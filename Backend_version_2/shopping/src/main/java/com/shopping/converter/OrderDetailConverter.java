package com.shopping.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.dto.OrderDTO;
import com.shopping.dto.OrderDetailDTO;
import com.shopping.dto.RateDTO;
import com.shopping.entities.Order;
import com.shopping.entities.OrderDetail;

@Component
public class OrderDetailConverter {
	
	
	@Autowired
	ModelMapper modelMapper;
	
	public OrderDetail toEntity(OrderDetailDTO orderDetailDTO) {

		OrderDetail orderDetail = modelMapper.map(orderDetailDTO, OrderDetail.class);

		return orderDetail;

	}

	public OrderDetailDTO toDTO(OrderDetail orderDetail) {

		OrderDetailDTO orderDetailDTO = modelMapper.map(orderDetail, OrderDetailDTO.class);
		
		orderDetailDTO.setOrder(null);
		
//		for (RateDTO item : orderDetailDTO.getProduct().getRates()) {
//			item.setProduct(null);
//		}

		return orderDetailDTO;
	}

}
