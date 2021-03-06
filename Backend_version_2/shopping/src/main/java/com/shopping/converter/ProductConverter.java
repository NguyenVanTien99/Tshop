package com.shopping.converter;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.shopping.dto.ProductDTO;
import com.shopping.dto.RateDTO;
import com.shopping.entities.Product;
import com.shopping.entities.Rates;

@Component
public class ProductConverter {

	@Autowired
	ModelMapper modelMapper;

	public Product toEntity(ProductDTO productDTO) {

		Product product = modelMapper.map(productDTO, Product.class);

		return product;

	}

	public ProductDTO toDTO(Product product) {
		
		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
		
//		if(productDTO.getRates() != null) {
//			for (RateDTO rate : productDTO.getRates()) {
//				rate.setProduct(null);
//			} 
//		}
		
		
		

		return productDTO;
	}
	
	
	public Page<ProductDTO> toPageProductDto(Page<Product> objects) {
	    Page<ProductDTO> dtos  = objects.map(this::toDTO);
	    return dtos;
	}
	

	

}
