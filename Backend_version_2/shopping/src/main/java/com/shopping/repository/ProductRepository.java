package com.shopping.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long > {
	
	List<Product> findByActiveTrue();
	
	List<Product> findByNameAndActiveTrue(String name);
	
	Product findByIdAndActiveTrue(Long id);
	
	Page<Product> findByActiveTrue(Pageable pageable);
	
	Page<Product> findByNameContainingAndActiveTrue(String name, Pageable pageable);
	
	List<Product> findByCategoryIdAndActiveTrue(Long id);
	
	Page<Product> findByCategoryIdAndActiveTrue(Long id, Pageable pageable);

	Page<Product> findByCategoryIdAndNameContainingAndActiveTrue(Long id, String name, Pageable pageable);
}
