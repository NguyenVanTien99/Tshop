package com.shopping.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.converter.RateConverter;
import com.shopping.dto.RateDTO;
import com.shopping.entities.Product;
import com.shopping.entities.Rates;
import com.shopping.exception.ResourceNotFoundException;
import com.shopping.repository.ProductRepository;
import com.shopping.repository.RateRepository;
import com.shopping.services.RateService;

@Service
public class RateServiceImpl implements RateService {
	
	@Autowired
	RateRepository rateRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	RateConverter rateConverter;

	@Override
	public RateDTO save(RateDTO rateDTO) {
		
		Product product = productRepository.findById(rateDTO.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + rateDTO.getProductId()));
		
		Rates rates = rateConverter.toEntity(rateDTO);
		
		rates.setProduct(product);
		
		Rates _rates = rateRepository.save(rates);
		
		return rateConverter.toDTO(_rates);
		
	}
	
	

}
