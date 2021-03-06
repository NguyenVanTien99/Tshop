package com.shopping.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entities.Product;
import com.shopping.entities.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
	
	List<ProductCategory> findByActiveTrue();
	
	Page<ProductCategory> findByActiveTrue(Pageable pageable);
	
	ProductCategory findByCategoryNameAndActiveTrue(String name);
	
	ProductCategory findByIdAndActiveTrue(Long id);

}
