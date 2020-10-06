package com.app.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CartDetailId implements Serializable {

	private Cart cart;
	private Production production;

	public CartDetailId() { }
	public CartDetailId(Cart cart, Production production) {
		this.cart = cart;
		this.production = production;
	}

	@ManyToOne
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@ManyToOne
	public Production getProduction() {
		return production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}
}
