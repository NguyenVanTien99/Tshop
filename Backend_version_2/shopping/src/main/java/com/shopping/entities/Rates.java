package com.shopping.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Rates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Double start;

	private String comment;

	@Column(name = "date_rate")
	@CreationTimestamp
	private Date dateRate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public Rates() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rates(Double start, String comment, Date dateRate, User user, Product product) {
		super();
		this.start = start;
		this.comment = comment;
		this.dateRate = dateRate;
		this.user = user;
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getStart() {
		return start;
	}

	public void setStart(Double start) {
		this.start = start;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDateRate() {
		return dateRate;
	}

	public void setDateRate(Date dateRate) {
		this.dateRate = dateRate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
