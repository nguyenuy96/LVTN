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
@Table(name = "production_type")
public class ProductType implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productTypeId;

	@Column(nullable = false, unique = true)
	private String productType;

	public ProductType() {
	}

	public ProductType(Long productTypeId, String productType) {
		this.productTypeId = productTypeId;
		this.productType = productType;
	}

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "productType")
	private Set<Production> production;

	public Set<Production> getProduction() {
		return production;
	}

	public void setProduction(Set<Production> production) {
		this.production = production;
	}

}
