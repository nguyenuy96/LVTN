package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name = "warehouse_id")
	private Warehouse warehouse;

	@OneToOne
	@JoinColumn(name = "production_id")
	private Production production;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	private double amount;

	private String importDate;
}
