package com.app.model;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CartDetail")
@AssociationOverrides({
		@AssociationOverride(name = "cartDetailId.cart", joinColumns = @JoinColumn(name = "cartId")),
		@AssociationOverride(name = "cartDetailId.product", joinColumns = @JoinColumn(name = "productId")) })
public class CartDetail implements Serializable {

	private CartDetailId cartDetailId = new CartDetailId();
	private Integer amount;

	@EmbeddedId
	public CartDetailId getCartDetailId() {
		return cartDetailId;
	}

	public void setCartDetailId(CartDetailId cartDetailId) {
		this.cartDetailId = cartDetailId;
	}

	@Transient
	public Cart getCart() {
		return getCartDetailId().getCart();
	}

	public void setCart(Cart cart) {
		getCartDetailId().setCart(cart);
	}

	@Transient
	public Production getProduct() {
		return getCartDetailId().getProduction();
	}

	public void setProduct(Production production) {
		getCartDetailId().setProduction(production);
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
