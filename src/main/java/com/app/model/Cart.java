package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "GIO_HANG")
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@Column(name = "MA_GIO_HANG")
	private int cartId;
	
	/******************************************************************************/
	
	@JsonProperty("amount")
	@Column(name = "SO_LUONG", nullable = false)
	private int amount;
	
	/******************************************************************************/
	
	@JsonProperty("total_price")
	@Column(name = "TONG_GIA", nullable = false)
	private double totalPrice;

	/******************************************************************************/
	
	@OneToOne
	@JoinColumn(name = "MA_SAN_PHAM", nullable = false)
	private Item itemId;
	
	/******************************************************************************/
	
	public Cart() { }
	
	public Cart(int cartId, int amount, double totalPrice, Item itemId) {
		this.cartId = cartId;
		this.amount = amount;
		this.totalPrice = totalPrice;
		this.itemId = itemId;
	}

	/******************************************************************************/
	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/******************************************************************************/
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	/******************************************************************************/
	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/******************************************************************************/

	public Item getItem() {
		return itemId;
	}

	public void setItem(Item itemId) {
		this.itemId = itemId;
	}
	
	/******************************************************************************/
	
}
