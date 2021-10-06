package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.dto.CartDetailDTO;
import com.shopping.services.CartDetailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cart-detail")
public class CartDetailControler {

	@Autowired
	CartDetailService cartDetailService;

	@PostMapping
	public ResponseEntity<CartDetailDTO> save(@RequestBody CartDetailDTO cartDetail) {

		CartDetailDTO cartDetailDTO = cartDetailService.save(cartDetail);

		return new ResponseEntity<CartDetailDTO>(cartDetailDTO, HttpStatus.CREATED);
	}

	@GetMapping("/cart/{id}")
	public ResponseEntity<List<CartDetailDTO>> getByCartId(@PathVariable("id") Long id) {

		List<CartDetailDTO> cartDetailDTOs = cartDetailService.getByCartId(id);

		return ResponseEntity.ok(cartDetailDTOs);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CartDetailDTO> getById(@PathVariable("id") Long id) {

		CartDetailDTO cartDetailDTO = cartDetailService.getById(id);

		return ResponseEntity.ok(cartDetailDTO);

	}
	
	@PutMapping
	public ResponseEntity<CartDetailDTO> update(@RequestBody CartDetailDTO cartDetail) {

		CartDetailDTO cartDetailDTO = cartDetailService.update(cartDetail);

		return ResponseEntity.ok(cartDetailDTO);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CartDetailDTO> delete (@PathVariable("id") long id) {
		cartDetailService.delete(id);
		return ResponseEntity.ok().build();
	} 
	

}
