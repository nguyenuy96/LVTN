package com.app.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	private Warehouse repository;

	/******************************************************************************/

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "NHAPKHO_SANPHAM", joinColumns = {
			@JoinColumn(name = "MA_NHAP_KHO", referencedColumnName = "MA_NHAP_KHO") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_SAN_PHAM", referencedColumnName = "MA_SAN_PHAM") })
	private Set<Product> product;

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	/******************************************************************************/
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "NHANVIEN_NHAPKHO", joinColumns = {
			@JoinColumn(name = "MA_NHAP_KHO", referencedColumnName = "MA_NHAP_KHO") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_NHAN_VIEN", referencedColumnName = "MA_NHAN_VIEN") })
	private Employee empId;

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

	public ProductStorageReceipt(int productStorageId, Employee empId, double amount, String importDate, Set<Product> product) {
		this.productStorageId = productStorageId;
		this.empId = empId;
		this.amount = amount;
		this.importDate = importDate;
		this.product = product;
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

	public Employee getEmployee() {
		return empId;
	}

	public void setEmployee(Employee empId) {
		this.empId = empId;
	}

}
