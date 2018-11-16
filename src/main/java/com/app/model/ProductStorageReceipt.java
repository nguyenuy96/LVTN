package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name = "NHAP_KHO")
public class ProductStorageReceipt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_NHAP_KHO", nullable = false, unique = true)
	private int productStorageId;

	/******************************************************************************/
	
	@ManyToOne
	@JoinTable(name = "NHAPKHO_KHOHANG", joinColumns = {
			@JoinColumn(name = "MA_NHAP_KHO", referencedColumnName = "MA_NHAP_KHO") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_KHO_HANG", referencedColumnName = "MA_KHO_HANG") })
	private Warehouse warehouse;

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	/******************************************************************************/

	@OneToOne
	@JoinTable(name = "NHAPKHO_SANPHAM", joinColumns = {
			@JoinColumn(name = "MA_NHAP_KHO", referencedColumnName = "MA_NHAP_KHO") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_SAN_PHAM", referencedColumnName = "MA_SAN_PHAM") })
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/******************************************************************************/
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "TAIKHOAN_NHAPKHO", joinColumns = {
			@JoinColumn(name = "MA_NHAP_KHO", referencedColumnName = "MA_NHAP_KHO") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_TAI_KHOAN", referencedColumnName = "MA_TAI_KHOAN") })
	private Account account;

	/******************************************************************************/

	@Column(name = "SO_LUONG")
	private double amount;

	/******************************************************************************/

	@Column(name = "NGAY_NHAP")
	private String importDate;

	/******************************************************************************/

	public ProductStorageReceipt() {
	}

	public ProductStorageReceipt(int productStorageId) {
		this.productStorageId = productStorageId;
	}

	public ProductStorageReceipt(int productStorageId, Account account, double amount, String importDate, Product product, Warehouse warehouse) {
		this.productStorageId = productStorageId;
		this.account = account;
		this.amount = amount;
		this.importDate = importDate;
		this.product = product;
		this.warehouse = warehouse;
	}

	/******************************************************************************/

	public int getProductStorageId() {
		return productStorageId;
	}

	public void setProductStorageId(int productStorageId) {
		this.productStorageId = productStorageId;
	}

	/******************************************************************************/

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	/******************************************************************************/
	public String getImportDate() {
		return importDate;
	}

	public void setImportDate(String importDate) {
		this.importDate = importDate;
	}

	/******************************************************************************/

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
