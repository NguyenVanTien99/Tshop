package com.shopping.entities;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal amount;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
	private Set<CartDetail> cartDetails;

	public Cart() {
		super();
	}

	public Cart(BigDecimal amount, User user, Set<CartDetail> cartDetails) {
		super();
		this.amount = amount;
		this.user = user;
		this.cartDetails = cartDetails;
	}

	public Cart(BigDecimal amount, User user) {
		super();
		this.amount = amount;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CartDetail> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(Set<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}

}
