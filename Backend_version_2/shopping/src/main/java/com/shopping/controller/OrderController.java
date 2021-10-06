package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.dto.OrderDTO;
import com.shopping.services.OrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping
	public ResponseEntity<OrderDTO> save(@RequestBody OrderDTO orderDTO) {

		OrderDTO _orderDTO = orderService.save(orderDTO);

		return new ResponseEntity<OrderDTO>(_orderDTO, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<OrderDTO> update(@RequestBody OrderDTO orderDTO) {
		
		System.out.println("puttt");

		OrderDTO _orderDTO = orderService.update(orderDTO);

		return new ResponseEntity<OrderDTO>(_orderDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Page<OrderDTO>> findAll(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {

		Page<OrderDTO> orders = this.orderService.getAll(page, size);

		return ResponseEntity.ok(orders);
	}

	@GetMapping("/user")
	public ResponseEntity<Page<OrderDTO>> findByUserId(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size, @RequestParam("userId") Long id) {

		Page<OrderDTO> orders = this.orderService.getByUserId(id, page, size);

		return ResponseEntity.ok(orders);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> findById(@PathVariable(value = "id") long id) {

		OrderDTO orders = this.orderService.getById(id);

		return ResponseEntity.ok(orders);
	}

}
