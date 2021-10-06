package com.shopping.dto;

public class CartDetailDTO {

	private Long id;

	private Integer quantity;
	
	private CartDTO cart;

	private ProductDTO product;

	public CartDetailDTO() {
		super();
	}

	public CartDetailDTO(Integer quantity, CartDTO cart, ProductDTO product) {
		super();
		this.quantity = quantity;
		this.cart = cart;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public CartDTO getCart() {
		return cart;
	}

	public void setCart(CartDTO cart) {
		this.cart = cart;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

}
