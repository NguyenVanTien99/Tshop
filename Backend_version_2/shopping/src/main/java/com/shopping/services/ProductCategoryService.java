package com.shopping.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.shopping.dto.ProductCategoryDTO;
import com.shopping.dto.ProductDTO;

public interface ProductCategoryService {
	
	List<ProductCategoryDTO> getAll();
	
	ProductCategoryDTO getByName(String name);
	
	Page<ProductCategoryDTO> getAllPaginate(Integer page, Integer size);
	
	ProductCategoryDTO save(ProductCategoryDTO product);

	ProductCategoryDTO update(ProductCategoryDTO product, Long id);
	
	ProductCategoryDTO findByid(Long id);

	void delete(Long id);

}
