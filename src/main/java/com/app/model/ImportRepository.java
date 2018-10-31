package com.app.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "NHAP_KHO")
public class ImportRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_NHAP_KHO", nullable = false, unique = true)
	private int impRespId;

	/******************************************************************************/
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MA_KHO_HANG", nullable = false)
	private Repository repositoryId;

	/******************************************************************************/

//	@JsonBackReference
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "MA_SAN_PHAM", nullable = false)
//	private Product productId;

	/******************************************************************************/
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MA_NHAN_VIEN")
	private Employee empId;
	
	/******************************************************************************/

	@Column(name = "SO_LUONG", nullable = false)
	private double amount;

	/******************************************************************************/

	@Column(name = "NGAY_NHAP", nullable = false)
	private Date importDate;

	/******************************************************************************/

	public ImportRepository() {}
	
	public ImportRepository(int impRespId, Repository repositoryId,/* Product productId,*/ Employee empId, double amount, Date importDate) {
		this.impRespId = impRespId;
		this.repositoryId = repositoryId;
//		this.productId = productId;
		this.empId = empId;
		this.amount = amount;
		this.importDate = importDate;
	}

	/******************************************************************************/

	public int getImpRespId() {
		return impRespId;
	}

	public void setImpRespId(int impRespId) {
		this.impRespId = impRespId;
	}

	/******************************************************************************/

	public Repository getRepository() {
		return repositoryId;
	}

	public void setRepository(Repository repositoryId) {
		this.repositoryId = repositoryId;
	}

	/******************************************************************************/
//
//	public Product getProduct() {
//		return productId;
//	}
//
//	public void setProduct(Product productId) {
//		this.productId = productId;
//	}

	/******************************************************************************/

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	/******************************************************************************/
	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
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
