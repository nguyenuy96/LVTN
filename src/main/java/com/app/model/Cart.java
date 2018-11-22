package com.app.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

//	@Column(name = "SO_LUONG")
//	private Integer amount;

	/******************************************************************************/

	@Column(name = "NGAY_CAP_NHAT")
	private Date lastUpdateDate;

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "SAN_PHAM_GIO_HANG", joinColumns = {
//			@JoinColumn(name = "MA_GIO_HANG", referencedColumnName = "MA_GIO_HANG"),
//			@JoinColumn(name = "SO_LUONG", referencedColumnName = "SO_LUONG")}, inverseJoinColumns = {
//					@JoinColumn(name = "MA_SAN_PHAM", referencedColumnName = "MA_SAN_PHAM", unique = false) })
//	private Set<Product> product;


	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<CartValue> cart_Products = new HashSet<CartValue>();
	public Set<CartValue> getCart_Products() {
		return cart_Products;
	}
	
	public void setCart_Products(Set<CartValue> cart_Products) {
		this.cart_Products = cart_Products;
	}

	public Cart() {
	}

	public Cart(int cartId, /*int amount, Double totalPrice, Set<Product> product,*/ Date lastUpdateDate) {
		this.cartId = cartId;
//		this.amount = amount;
//		this.product = product;
		this.lastUpdateDate = lastUpdateDate;
//		this.cart_Products = cart_Products;
	}

	/******************************************************************************/

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/******************************************************************************/

//	public Integer getAmount() {
//		return amount;
//	}
//
//	public void setAmount(int amount) {
//		this.amount = amount;
//	}

	/******************************************************************************/
//
//	public Set<Product> getProduct() {
//		return product;
//	}
//
//	public void setProduct(Set<Product> product) {
//		this.product = product;
//	}

	/******************************************************************************/
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

}
