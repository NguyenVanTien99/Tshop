package com.shopping.dto;

public class OrderDetailDTO {

	private Long id;

	private Integer quantity;

	private OrderDTO order;

	private ProductDTO product;

	public OrderDetailDTO() {
		super();
	}

	public OrderDetailDTO(Long id, Integer quantity, OrderDTO order, ProductDTO product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.order = order;
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

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

}
