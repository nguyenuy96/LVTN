package com.app.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "NGAY_CAP_NHAT")
	private Date lastUpdateDate;

	@OneToMany(mappedBy = "cartDetailId.cart", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<CartDetail> cartDetail = new HashSet<CartDetail>();
	public Set<CartDetail> getCartDetail() {
		return cartDetail;
	}
	
	public void setCartDetail(Set<CartDetail> cartDetail) {
		this.cartDetail = cartDetail;
	}

	public Cart() {
	}

	public Cart(int cartId, Date lastUpdateDate) {
		this.cartId = cartId;
		this.lastUpdateDate = lastUpdateDate;
	}

	/******************************************************************************/

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/******************************************************************************/
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

}
