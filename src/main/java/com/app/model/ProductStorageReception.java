package com.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "production_storage_reception")
public class ProductStorageReception implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productStorageReceptionId;
	
	@ManyToOne
	@JoinTable(name = "production_of_warehouse", joinColumns = {
			@JoinColumn(name = "productStorageReceptionId", referencedColumnName = "productStorageReceptionId") }, inverseJoinColumns = {
					@JoinColumn(name = "warehouseId", referencedColumnName = "warehouseId") })
	private Warehouse warehouse;

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@OneToOne
	@JoinTable(name = "production_storage", joinColumns = {
			@JoinColumn(name = "productStorageReceptionId", referencedColumnName = "productStorageReceptionId") }, inverseJoinColumns = {
					@JoinColumn(name = "productionId", referencedColumnName = "productionId") })
	private Production production;

	public Production getProduction() {
		return production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

	/******************************************************************************/
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "account_of_storage_reception", joinColumns = {
			@JoinColumn(name = "productStorageReceptionId", referencedColumnName = "productStorageReceptionId") }, inverseJoinColumns = {
					@JoinColumn(name = "accountId", referencedColumnName = "accountId") })
	private Account account;

	private double amount;

	private String importDate;

	public ProductStorageReception() {
	}

	public ProductStorageReception(Long productStorageReceptionId) {
		this.productStorageReceptionId = productStorageReceptionId;
	}

	public ProductStorageReception(Long productStorageReceptionId, Account account, double amount, String importDate, Production production, Warehouse warehouse) {
		this.productStorageReceptionId = productStorageReceptionId;
		this.account = account;
		this.amount = amount;
		this.importDate = importDate;
		this.production = production;
		this.warehouse = warehouse;
	}

	public Long getProductStorageReceptionId() {
		return productStorageReceptionId;
	}

	public void setProductStorageReceptionId(Long productStorageReceptionId) {
		this.productStorageReceptionId = productStorageReceptionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getImportDate() {
		return importDate;
	}

	public void setImportDate(String importDate) {
		this.importDate = importDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
