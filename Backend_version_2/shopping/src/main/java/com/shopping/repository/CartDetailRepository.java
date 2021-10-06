package com.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entities.CartDetail;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
	
	List<CartDetail> findByCartId(Long id);

}

