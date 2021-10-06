package com.shopping.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.shopping.entities.User;

public class OrderDTO {

	private Long id;

	private String name;

	private String address;

	private String phone;

	private BigDecimal amount;

	private String orderTrackingNumber;

	private String description;

	private Integer status;

	private Date dateOrdered;

	private Date dateDeliveryDate;

	private Date dateReceipt;

	private User user;

	private Set<OrderDetailDTO> orderDetails;

	public OrderDTO() {
		super();
	}

	public OrderDTO(String name, String address, String phone, BigDecimal amount, String orderTrackingNumber,
			Integer status, Date dateOrdered, Date dateDeliveryDate, Date dateReceipt, User user,
			Set<OrderDetailDTO> orderDetails) {
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

	public Set<OrderDetailDTO> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetailDTO> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
