package com.shopping.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> { 
	
	Page<Order> findByUserId(Long id, Pageable pageable);

}
