package com.app.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GIO_HANG")
public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_GIO_HANG")
	private Integer cartId;

	/******************************************************************************/

	@Column(name = "SO_LUONG", nullable = false)
	private Integer amount;

	/******************************************************************************/

	@Column(name = "TONG_GIA", nullable = false)
	private Double totalPrice;

	/******************************************************************************/

	@OneToMany
	@JoinTable(name = "SAN_PHAM_GIO_HANG", joinColumns = {
			@JoinColumn(name = "MA_GIO_HANG", referencedColumnName = "MA_GIO_HANG") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_SAN_PHAM", referencedColumnName = "MA_SAN_PHAM") })
	private Set<Product> product;

	public Cart() {
	}

	public Cart(int cartId, int amount, Double totalPrice, Set<Product> product) {
		this.cartId = cartId;
		this.amount = amount;
		this.totalPrice = totalPrice;
		this.product = product;
	}

	/******************************************************************************/

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/******************************************************************************/

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	/******************************************************************************/

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/******************************************************************************/
	
	 public Set<Product> getProduct() {
	 return product;
	 }
	
	 public void setProduct(Set<Product> product) {
	 this.product = product;
	 }

	/******************************************************************************/

}
