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
@Table(name = "XUAT_KHO")
public class ProductExportReceipt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_XUAT_KHO", nullable = false, unique = true)
	private Integer productExportReceiptId;
	
	/******************************************************************************/
	
	@ManyToOne
	@JoinTable(name = "XUAT_KHO_KHO_HANG", joinColumns = {
			@JoinColumn(name = "MA_XUAT_KHO", referencedColumnName = "MA_XUAT_KHO") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_KHO_HANG", referencedColumnName = "MA_KHO_HANG") })
	private Warehouse warehouse;

	/******************************************************************************/
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "XUAT_KHO_SAN_PHAM", joinColumns = {
			@JoinColumn(name = "MA_XUAT_KHO", referencedColumnName = "MA_XUAT_KHO") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_SAN_PHAM", referencedColumnName = "MA_SAN_PHAM") })
	private Set<Product> product;

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "NHAN_VIEN_XUAT_KHO", joinColumns = {
			@JoinColumn(name = "MA_XUAT_KHO", referencedColumnName = "MA_XUAT_KHO") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_NHAN_VIEN", referencedColumnName = "MA_NHAN_VIEN") })
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	/******************************************************************************/

	@Column(name = "SO_LUONG")
	private Double amount;

	/******************************************************************************/

	@Column(name = "NGAY_XUAT")
	private String exportDate;

	/******************************************************************************/
	
	public ProductExportReceipt() { }
	
	public ProductExportReceipt(Integer productExportReceiptId) {
		this.productExportReceiptId = productExportReceiptId;
	}

	public ProductExportReceipt(int productExportReceiptId, Warehouse warehouse, Set<Product> product, Employee employee, Double amount, String exportDate) {
		this.productExportReceiptId = productExportReceiptId;
		this.warehouse = warehouse;
		this.product = product;
		this.employee = employee;
		this.amount = amount;
		this.exportDate = exportDate;
	}

	/******************************************************************************/

	public Integer getProductExportReceiptId() {
		return productExportReceiptId;
	}

	public void setProductExportReceiptId(Integer productExportReceiptId) {
		this.productExportReceiptId = productExportReceiptId;
	}

	/******************************************************************************/

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}


	/******************************************************************************/

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/******************************************************************************/
	public String getExportDate() {
		return exportDate;
	}

	public void setExportDate(String exportDate) {
		this.exportDate = exportDate;
	}

	/******************************************************************************/
	
//	public Employee getEmployee() {
//		return empId;
//	}
//
//	public void setEmployee(Employee empId) {
//		this.empId = empId;
//	}
	
}
