package com.shopping.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product_category")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Size(min = 2, message = "Product category name should have at least 2 characters")
	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "description")
	private String description;

	@Column(name = "active")
	private Boolean active;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private Set<Product> products;

	public ProductCategory() {
		super();
	}

	public ProductCategory(String categoryName, Set<Product> products) {
		super();
		this.categoryName = categoryName;
		this.products = products;
	}

	public ProductCategory(Long id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	public ProductCategory(Long id, String categoryName, Set<Product> products) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.products = products;
	}

	public ProductCategory(Long id,
			@NotEmpty @Size(min = 2, message = "Product category name should have at least 2 characters") String categoryName,
			String description) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.description = description;
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
