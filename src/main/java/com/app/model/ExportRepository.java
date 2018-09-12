package com.app.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "XUAT_KHO")
public class ExportRepository implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int expRespId;
	
	/******************************************************************************/
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "MA_KHO_HANG", nullable = false)
	private Repository repositoryId;

	/******************************************************************************/

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "MA_SAN_PHAM", nullable = false)
	private Item itemId;

	/******************************************************************************/
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "MA_NHAN_VIEN", nullable = false)
	private Staff staffId;
	
	/******************************************************************************/

	@Column(name = "SO_LUONG", nullable = false)
	private double amount;

	/******************************************************************************/

	@Column(name = "NGAY_XUAT", nullable = false)
	private Date importDate;

	/******************************************************************************/
	
	public ExportRepository() { }

	public ExportRepository(int expRespId, Repository repositoryId, Item itemId, Staff staffId, double amount, Date importDate) {
		this.expRespId = expRespId;
		this.repositoryId = repositoryId;
		this.itemId = itemId;
		this.staffId = staffId;
		this.amount = amount;
		this.importDate = importDate;
	}

	/******************************************************************************/

	public int getExpRespId() {
		return expRespId;
	}

	public void setExpRespId(int expRespId) {
		this.expRespId = expRespId;
	}

	/******************************************************************************/

	public Repository getRepository() {
		return repositoryId;
	}

	public void setRepository(Repository repositoryId) {
		this.repositoryId = repositoryId;
	}

	/******************************************************************************/

	public Item getItem() {
		return itemId;
	}

	public void setItem(Item itemId) {
		this.itemId = itemId;
	}

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
	
	public Staff getStaff() {
		return staffId;
	}

	public void setStaff(Staff staffId) {
		this.staffId = staffId;
	}
	
}