package com.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
	
	List<OrderDetail> findByOrderId(Long id);

}
