package com.shopping.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProductCategoryDTO {

	private Long id;

	@NotEmpty
	@Size(min = 2, message = "Product category name should have at least 2 characters")
	private String categoryName;
	
	@Size(max = 255, message = "Product description should have at least 255 characters")
	private String description;
	
	private Boolean active;

	public ProductCategoryDTO() {
		super();
	}

	public ProductCategoryDTO(Long id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}
	
	public ProductCategoryDTO(Long id, String categoryName, String des) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.description = des;
	}
	
	

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
