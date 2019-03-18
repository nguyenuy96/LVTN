package com.app.model;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "GIO_HANG_SAN_PHAM")
@AssociationOverrides({
		@AssociationOverride(name = "cartDetailId.cart", joinColumns = @JoinColumn(name = "MA_GIO_HANG")),
		@AssociationOverride(name = "cartDetailId.product", joinColumns = @JoinColumn(name = "MA_SAN_PHAM")) })
public class CartDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	public Product getProduct() {
		return getCartDetailId().getProduct();
	}

	public void setProduct(Product product) {
		getCartDetailId().setProduct(product);
	}

	@Column(name = "SO_LUONG")
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
