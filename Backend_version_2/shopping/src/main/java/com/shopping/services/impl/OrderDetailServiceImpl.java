package com.shopping.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.converter.OrderDetailConverter;
import com.shopping.dto.OrderDetailDTO;
import com.shopping.entities.OrderDetail;
import com.shopping.repository.OrderDetailRepository;
import com.shopping.services.OrderDetailService;

@Component
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Autowired
	OrderDetailConverter orderDetailConverter;

	@Override
	public OrderDetailDTO save(OrderDetailDTO orderDetailDTO) {

		OrderDetail orderDetail = orderDetailRepository.save(orderDetailConverter.toEntity(orderDetailDTO));

		return orderDetailConverter.toDTO(orderDetail);
	}

	@Override
	public List<OrderDetailDTO> getAllByOrderId(Long id) {

		List<OrderDetail> details = orderDetailRepository.findByOrderId(id);

		List<OrderDetailDTO> detailDTOs = new ArrayList<OrderDetailDTO>();

		for (OrderDetail orderDetail : details) {

			detailDTOs.add(orderDetailConverter.toDTO(orderDetail));

		}

		return detailDTOs;
	}

}
