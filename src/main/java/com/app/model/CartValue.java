package com.app.model;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

//
//@Entity
//@Table(name = "GIO_HANG_SAN_PHAM")
// @AssociationOverrides({ @AssociationOverride(name = "primaryKey.cart", joinColumns = @JoinColumn(name = "MA_GIO_HANG")),
//		@AssociationOverride(name = "primaryKey.product", joinColumns = @JoinColumn(name = "MA_SAN_PHAM")) })
@Entity
@Table(name = "SAN_PHAM_GIO_HANG")
public class CartValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//
	// private CartProductId primaryKey;
	// private Integer amount;
	//
	// @EmbeddedId
	// public CartProductId getPrimaryKey() {
	// return primaryKey;
	// }
	//
	// public void setPrimaryKey(CartProductId primaryKey) {
	// this.primaryKey = primaryKey;
	// }
	//
	// @Transient
	// public Cart getCart() {
	// return getPrimaryKey().getCart();
	// }
	//
	// public void setCart(Cart cart) {
	// getPrimaryKey().setCart(cart);
	// }
	//
	// @Transient
	// public Product getProduct() {
	// return getPrimaryKey().getProduct();
	// }
	//
	// public void setProduct(Product product) {
	// getPrimaryKey().setProduct(product);
	// }
	//
	// @Column(name = "SO_LUONG")
	// public Integer getAmount() {
	// return amount;
	// }
	//
	// public void setAmount(Integer amount) {
	// this.amount = amount;
	// }

	private Integer cartValueId;
	private Cart cart;
	private Product product;
	private Integer amount;

	public CartValue() {

	}

	public CartValue(Integer cartValueId, Cart cart, Product product, Integer amount) {
		this.cartValueId = cartValueId;
		this.cart = cart;
		this.product = product;
		this.amount = amount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_GIA_TRI_GIO_HANG")
	public Integer getCartValueId() {
		return cartValueId;
	}

	public void setCartValueId(Integer cartValueId) {
		this.cartValueId = cartValueId;
	}

	@ManyToOne
    @JoinColumn(name = "MA_GIO_HANG")
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@ManyToOne
    @JoinColumn(name = "MA_SAN_PHAM")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "SO_LUONG")
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
