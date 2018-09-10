package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HOA_DON")
public class Bill implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int billId;

	/******************************************************************************/
	
	@Column(name = "LOAI_THANH_TOAN")
	private String payment;
	
	/******************************************************************************/
	
	@Column(name = "THANH_TOAN")
	private boolean isPay;
	
	/******************************************************************************/
	
	@Column(name = "GIAO_HANG")
	private boolean isDilivery;
	
	/******************************************************************************/
	
	public Bill(int billId) {
		this.billId = billId;
	}

	public Bill(int billId, String payment, boolean isPay, boolean isDilivery) {
		super();
		this.billId = billId;
		this.payment = payment;
		this.isPay = isPay;
		this.isDilivery = isDilivery;
	}

	/******************************************************************************/
	
	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	/******************************************************************************/
	
	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	/******************************************************************************/
	
	public boolean isPay() {
		return isPay;
	}

	public void setPay(boolean isPay) {
		this.isPay = isPay;
	}

	/******************************************************************************/
	
	public boolean isDilivery() {
		return isDilivery;
	}

	public void setDilivery(boolean isDilivery) {
		this.isDilivery = isDilivery;
	}
	
	/******************************************************************************/
	
	@OneToOne
	@JoinColumn(name = "KHACH_HANG")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/******************************************************************************/
	
	@OneToOne
	@JoinColumn(name = "NHAN_VIEN")
	private Staff staff;

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
}
