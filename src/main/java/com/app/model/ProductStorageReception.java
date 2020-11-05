package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "production_storage_reception")
public class ProductStorageReception {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productStorageReceptionId;
	
	@ManyToOne
	@JoinTable(name = "production_of_warehouse", joinColumns = {
			@JoinColumn(name = "productStorageReceptionId", referencedColumnName = "productStorageReceptionId") }, inverseJoinColumns = {
					@JoinColumn(name = "warehouseId", referencedColumnName = "warehouseId") })
	private Warehouse warehouse;

	@OneToOne
	@JoinTable(name = "production_storage", joinColumns = {
			@JoinColumn(name = "productStorageReceptionId", referencedColumnName = "productStorageReceptionId") }, inverseJoinColumns = {
					@JoinColumn(name = "productionId", referencedColumnName = "productionId") })
	private Production production;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "account_of_storage_reception", joinColumns = {
			@JoinColumn(name = "productStorageReceptionId", referencedColumnName = "productStorageReceptionId") }, inverseJoinColumns = {
					@JoinColumn(name = "accountId", referencedColumnName = "accountId") })
	private Account account;

	private double amount;

	private String importDate;

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
}
