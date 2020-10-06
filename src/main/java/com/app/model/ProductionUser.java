package com.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "production_user")
public class ProductionUser implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productionUserId;
	private String productionUser;
	
	public ProductionUser() {
		
	}
	
	public ProductionUser(Long productionUserId, String productionUser) {
		this.productionUserId = productionUserId;
		this.productionUser = productionUser;
	}
	
	public Long getProductionUserId() {
		return productionUserId;
	}
	
	public void setProductionUserId(Long productionUserId) {
		this.productionUserId = productionUserId;
	}
	
	public String getProductionUser() {
		return productionUser;
	}
	
	public void setProductionUser(String productionUser) {
		this.productionUser = productionUser;
	}
}
