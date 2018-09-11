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
public class Bill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int billId;

	/******************************************************************************/

	@Column(name = "LOAI_THANH_TOAN", nullable = false)
	private String payment;

	/******************************************************************************/

	@Column(name = "THANH_TOAN", nullable = false)
	private boolean isPay;

	/******************************************************************************/

	@Column(name = "GIAO_HANG", nullable = false)
	private boolean isDelivery;

	/******************************************************************************/
	
	@Column(name = "NOI_GIAO_HANG", nullable = false)
	private String addressDelivery;
	
	/******************************************************************************/
	
	@Column(name = "SDT_GIAO_HANG", nullable = false)
	private String phoneDelivery;

	/******************************************************************************/
	
	@OneToOne
	@JoinColumn(name = "MA_KHACH_HANG", nullable = false)
	private Customer customerId;

	/******************************************************************************/

	@OneToOne
	@JoinColumn(name = "MA_NHAN_VIEN", nullable = false)
	private Staff staffId;

	/******************************************************************************/

	@OneToOne
	@JoinColumn(name = "MA_GIO_HANG", nullable = false)
	private Cart cartId;

	/******************************************************************************/

	public Bill(int billId) {
		this.billId = billId;
	}

	public Bill(int billId, String payment, boolean isPay, boolean isDelivery, String addressDelivery, String phoneDelivery, Customer customerId, Staff staffId,
			Cart cartId) {
		this.billId = billId;
		this.payment = payment;
		this.isPay = isPay;
		this.isDelivery = isDelivery;
		this.addressDelivery = addressDelivery;
		this.phoneDelivery = phoneDelivery;
		this.customerId = customerId;
		this.staffId = staffId;
		this.cartId = cartId;
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

	public boolean isDelivery() {
		return isDelivery;
	}

	public void setDelivery(boolean isDelivery) {
		this.isDelivery = isDelivery;
	}

	/******************************************************************************/

	public String getAddressDelivery() {
		return addressDelivery;
	}
	
	public void setAddressDelivery(String addressDelivery) {
		this.addressDelivery = addressDelivery;
	}
	
	/******************************************************************************/
	
	public String getPhoneDelivery() {
		return phoneDelivery;
	}
	
	public void setPhoneDelivery(String phoneDelivery) {
		this.phoneDelivery = phoneDelivery;
	}
	
	/******************************************************************************/
	
	public Customer getCustomer() {
		return customerId;
	}

	public void setCustomer(Customer customerId) {
		this.customerId = customerId;
	}

	/******************************************************************************/

	public Staff getStaff() {
		return staffId;
	}

	public void setStaff(Staff staffId) {
		this.staffId = staffId;
	}

	/******************************************************************************/

	public Cart getCart() {
		return cartId;
	}

	public void setCart(Cart cartId) {
		this.cartId = cartId;
	}

}
