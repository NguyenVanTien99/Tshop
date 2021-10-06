package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.dto.OrderDTO;
import com.shopping.dto.OrderDetailDTO;
import com.shopping.services.OrderDetailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/order-detail")
public class OrderDetailController {
	
	@Autowired
	OrderDetailService orderDetailService; 
	
	@PostMapping
	public ResponseEntity<OrderDetailDTO> save(@RequestBody OrderDetailDTO orderDetailDTO ) {

		OrderDetailDTO _orderDetailDTO = orderDetailService.save(orderDetailDTO);

		return new ResponseEntity<OrderDetailDTO>(_orderDetailDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<OrderDetailDTO>> findById(@PathVariable(value = "id") long id) {

		List<OrderDetailDTO> _orderDetailDTO = this.orderDetailService.getAllByOrderId(id);

		return ResponseEntity.ok(_orderDetailDTO);
	}

}
