package com.shopping.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.converter.CartDetailConverter;
import com.shopping.dto.CartDetailDTO;
import com.shopping.entities.CartDetail;
import com.shopping.exception.ResourceNotFoundException;
import com.shopping.repository.CartDetailRepository;
import com.shopping.services.CartDetailService;
import com.shopping.services.ProductService;

@Service
public class CartDetailServiceImpl implements CartDetailService {

	@Autowired
	ProductService productService;

	@Autowired
	CartDetailRepository cartDetailRepository;

	@Autowired
	CartDetailConverter cartDetailConverter;

	@Override
	public CartDetailDTO save(CartDetailDTO cartDetailDTO) {

		List<CartDetail> cartDetails = cartDetailRepository.findByCartId(cartDetailDTO.getCart().getId());

		for (CartDetail cartDetail : cartDetails) {

			if (cartDetail.getProduct().getId() == cartDetailDTO.getProduct().getId()) {
				cartDetail.setQuantity(cartDetail.getQuantity() + 1);
				CartDetail _cartDetail = cartDetailRepository.save(cartDetail);
				return cartDetailConverter.toDTO(_cartDetail);
			}
		}

		CartDetail _cartDetail = cartDetailRepository.save(cartDetailConverter.toEntity(cartDetailDTO));

		return cartDetailConverter.toDTO(_cartDetail);

	}

	@Override
	public List<CartDetailDTO> getByCartId(Long id) {

		List<CartDetail> cartDetails = cartDetailRepository.findByCartId(id);

		List<CartDetailDTO> cartDetailDTOs = new ArrayList<CartDetailDTO>();

		for (CartDetail cartDetail : cartDetails) {
			cartDetailDTOs.add(cartDetailConverter.toDTO(cartDetail));
		}

		return cartDetailDTOs;

	}

	@Override
	public CartDetailDTO getById(Long id) {
		
		CartDetail cartDetail = cartDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart detail not found with id :" + id));

		return cartDetailConverter.toDTO(cartDetail);
	}

	@Override
	public CartDetailDTO update(CartDetailDTO cartDetailDTO) {
		
		CartDetail cartDetail = cartDetailRepository.save(cartDetailConverter.toEntity(cartDetailDTO));

		return cartDetailConverter.toDTO(cartDetail);
	}

	@Override
	public void delete(Long id) {
		cartDetailRepository.deleteById(id);
	}

}
