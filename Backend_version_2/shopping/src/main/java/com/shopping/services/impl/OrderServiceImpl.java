package com.shopping.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopping.converter.OrderConverter;
import com.shopping.dto.OrderDTO;
import com.shopping.entities.Order;
import com.shopping.entities.OrderDetail;
import com.shopping.exception.ResourceNotFoundException;
import com.shopping.repository.OrderRepository;
import com.shopping.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderConverter orderConverter;
	


	@Override
	public OrderDTO save(OrderDTO orderDTO) {
	
		Order order = orderRepository.save(orderConverter.toEntity(orderDTO));

		return orderConverter.toDTO(order);
	}

	@Override
	public Page<OrderDTO> getByUserId(Long id, Integer page, Integer size) {
		Pageable paging = PageRequest.of(page, size);

		Page<Order> orderPage = orderRepository.findByUserId(id, paging);

		Page<OrderDTO> orderDtoPage = orderConverter.toPageDto(orderPage);

		return orderDtoPage;
	}

	@Override
	public OrderDTO getById(Long id) {

		Order order = orderRepository.getById(id);

		return orderConverter.toDTO(order);

	}

	@Override
	public Page<OrderDTO> getAll(Integer page, Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Order> orderPage = orderRepository.findAll(paging);
		Page<OrderDTO> orderDtoPage = orderConverter.toPageDto(orderPage);
		return orderDtoPage;
	}

	@Override
	public OrderDTO update(OrderDTO orderDTO) {
		
		
		Order order = orderRepository.findById(orderDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Product not found with id :"));
		
		order.setStatus(orderDTO.getStatus());
		
//		for (OrderDetail detail: order.getOrderDetails()) {
//			detail.getOrder().setId(orderDTO.getId());
//		}
		
		Order _order = orderRepository.save(order);

		return orderConverter.toDTO(_order);
		
	}

}
