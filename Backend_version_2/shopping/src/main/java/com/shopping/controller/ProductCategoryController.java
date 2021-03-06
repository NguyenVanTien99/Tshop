package com.shopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.dto.ProductCategoryDTO;
import com.shopping.dto.ProductDTO;
import com.shopping.entities.Product;
import com.shopping.entities.ProductCategory;
import com.shopping.services.ProductCategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/product-category")
public class ProductCategoryController {
	
	@Autowired
	ProductCategoryService productCategoryService;
	
	@GetMapping
	public List<ProductCategoryDTO> getAllProducts() {
		return productCategoryService.getAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductCategoryDTO> getAllProductsPaginate(@PathVariable("id") long id) {

		ProductCategoryDTO products = productCategoryService.findByid(id);

		return new ResponseEntity<ProductCategoryDTO>(products, HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<Page<ProductCategoryDTO>> getAllProductsPaginate(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {

		Page<ProductCategoryDTO> products = productCategoryService.getAllPaginate(page, size);

		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/search")
	public ResponseEntity<ProductCategoryDTO> getAllProductsPaginate(@RequestParam("name") String name) {

		ProductCategoryDTO products = productCategoryService.getByName(name);

		return ResponseEntity.ok(products);
	}
	
	
	@PostMapping
	public ResponseEntity<ProductCategoryDTO> createProduct(@Valid @RequestBody ProductCategoryDTO product) {

		ProductCategoryDTO newProduct = productCategoryService.save(product);

		return new ResponseEntity<ProductCategoryDTO>(newProduct, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductCategory> deleteProduct(@PathVariable("id") long id) {
		productCategoryService.delete(id);
		return ResponseEntity.ok().build();
	}

}
