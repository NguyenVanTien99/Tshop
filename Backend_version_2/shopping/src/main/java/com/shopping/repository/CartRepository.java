package com.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	List<Cart> findByUserId(Long id);

}
