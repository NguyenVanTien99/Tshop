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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String address;

	private String phone;

	private BigDecimal amount;

	private String description;

	@Column(name = "order_tracking_number")
	private String orderTrackingNumber;

	private Integer status;

	@Column(name = "date_created")
	@CreationTimestamp
	private Date dateOrdered;

	@Column(name = "date_delivery")
	private Date dateDeliveryDate;

	@Column(name = "date_receipt")
	private Date dateReceipt;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
	private Set<OrderDetail> orderDetails;

	public Order() {
		super();
	}

	public Order(String name, String address, String phone, BigDecimal amount, String orderTrackingNumber,
			Integer status, Date dateOrdered, Date dateDeliveryDate, Date dateReceipt, User user,
			Set<OrderDetail> orderDetails) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.amount = amount;
		this.orderTrackingNumber = orderTrackingNumber;
		this.status = status;
		this.dateOrdered = dateOrdered;
		this.dateDeliveryDate = dateDeliveryDate;
		this.dateReceipt = dateReceipt;
		this.user = user;
		this.orderDetails = orderDetails;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public Date getDateDeliveryDate() {
		return dateDeliveryDate;
	}

	public void setDateDeliveryDate(Date dateDeliveryDate) {
		this.dateDeliveryDate = dateDeliveryDate;
	}

	public Date getDateReceipt() {
		return dateReceipt;
	}

	public void setDateReceipt(Date dateReceipt) {
		this.dateReceipt = dateReceipt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
