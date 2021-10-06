package com.shopping.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "sku")
	private String sku;

	@Column(name = "name", columnDefinition = "NVARCHAR(255)")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "unit_price")
	private BigDecimal unitPrice;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "image_store")
	@Lob
	private String imageStore;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "unit_in_stock")
	private int unitInStock;

	@Column(name = "date_created")
	@CreationTimestamp
	private Date dateCreated;

	@Column(name = "last_update")
	@UpdateTimestamp
	private Date lastUpdated;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "category_id")
	private ProductCategory category;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private Set<OrderDetail> orderDetails;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private Set<CartDetail> cartDetails;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private Set<Rates> rates;

	public Product() {
		super();
	}

	public Product(String sku, String name, String description, BigDecimal unitPrice, String imageUrl, Boolean active,
			int unitInStock, Date dateCreated, Date lastUpdated, ProductCategory category) {
		super();
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.imageUrl = imageUrl;
		this.active = active;
		this.unitInStock = unitInStock;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.category = category;
	}

	public Product(Long id, String sku, String name, String description, BigDecimal unitPrice, String imageUrl,
			Boolean active, int unitInStock, Date dateCreated, Date lastUpdated, ProductCategory category) {
		super();
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.imageUrl = imageUrl;
		this.active = active;
		this.unitInStock = unitInStock;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.category = category;
	}

	public String getImageStore() {
		return imageStore;
	}

	public void setImageStore(String imageStore) {
		this.imageStore = imageStore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public int getUnitInStock() {
		return unitInStock;
	}

	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", sku=" + sku + ", name=" + name + ", description=" + description + ", unitPrice="
				+ unitPrice + ", imageUrl=" + imageUrl + ", active=" + active + ", unitInStock=" + unitInStock
				+ ", dateCreated=" + dateCreated + ", lastUpdated=" + lastUpdated + ", category=" + category + "]";
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Set<CartDetail> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(Set<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public Set<Rates> getRates() {
		return rates;
	}

	public void setRates(Set<Rates> rates) {
		this.rates = rates;
	}

}
