package com.app.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "LOAI_HANG")
public class ProductType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_LOAI_HANG", nullable = false, unique = true)
	private int productTypeId;

	/******************************************************************************/

	@Column(name = "LOAI_HANG", nullable = false, unique = true)
	private String productType;

	/******************************************************************************/

	public ProductType() {
	}

	public ProductType(int productTypeId, String productType) {
		this.productTypeId = productTypeId;
		this.productType = productType;
	}

	/******************************************************************************/

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	/******************************************************************************/

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	/******************************************************************************/

	@JsonIgnore
	@OneToMany(mappedBy = "productType")
	private Set<Product> product;

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

}
