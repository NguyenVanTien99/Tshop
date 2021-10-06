package com.shopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.dto.ProductDTO;
import com.shopping.entities.Product;
import com.shopping.services.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<ProductDTO> getAllProducts() {
		return productService.getAll();
	}

	@GetMapping("/all")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Page<ProductDTO>> getAllProductsPaginate(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {

		Page<ProductDTO> products = productService.getAllPaginate(page, size);

		return ResponseEntity.ok(products);

	}
	
	@GetMapping("/new")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Page<ProductDTO>> getNewProductsPaginate(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {

		Page<ProductDTO> products = productService.getNewProduct(page, size);

		return ResponseEntity.ok(products);

	}
	
	@GetMapping("/price-desc")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Page<ProductDTO>> getProductsByPriceDesc(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {

		Page<ProductDTO> products = productService.getByPriceDesc(page, size);

		return ResponseEntity.ok(products);

	}
	
	@GetMapping("/price-asc")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Page<ProductDTO>> getProductsByPriceAsc(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {

		Page<ProductDTO> products = productService.getByPriceAsc(page, size);

		return ResponseEntity.ok(products);

	}
	
	@GetMapping("/search")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Page<ProductDTO>> getAllProductsPaginate1(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size , @RequestParam("name") String name) {

		Page<ProductDTO> products = productService.getByName(name , page, size);

		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/filter")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Page<ProductDTO>> getAllProductsPaginate2(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size , @RequestParam("categoryId") Long id) {

		Page<ProductDTO> products = productService.getByCategory(id , page, size);

		return ResponseEntity.ok(products);
	}

	@GetMapping("/{id}")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ProductDTO getProductById(@PathVariable(value = "id") long id) {
		return productService.getById(id);
	}
	
	
	@GetMapping("category/{id}")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<ProductDTO> getProductByCategoryId(@PathVariable(value = "id") long id) {
		return productService.getByCategoryid(id);
	}

	@PostMapping
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO product) {

		ProductDTO newProduct = productService.save(product);

		return new ResponseEntity<ProductDTO>(newProduct, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<ProductDTO> updateProduct(@Valid @RequestBody ProductDTO product, @PathVariable("id") long id) {
		ProductDTO newProduct = productService.update(product, id);
		return new ResponseEntity<ProductDTO>(newProduct, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id) {
		productService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/filter-category-name")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Page<ProductDTO>> findByCatgoryAndName(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size , @RequestParam("name") String name, @RequestParam("categoryId") Long id) {

		Page<ProductDTO> products = this.productService.findByNameAndCategory(id, name, page, size);
		
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String admin() {
			return "for admin";
	}
	
	@GetMapping("/mod")
	@PreAuthorize("hasRole('MOD')")
	public String mod() {
			return "for mod";
	}

}
