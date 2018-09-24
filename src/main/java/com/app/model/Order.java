package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DON_HANG")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_DON_HANG", nullable = false, unique = true)
	private int orderId;

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
	@JoinTable(name = "DONHANG_KHACHHANG", joinColumns = {
			@JoinColumn(name = "MA_DON_HANG", referencedColumnName = "MA_DON_HANG") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_KHACH_HANG", referencedColumnName = "MA_KHACH_HANG", unique = true) })
	private Customer customerId;

	/******************************************************************************/

	@OneToOne
	@JoinTable(name = "DONHANG_NHANVIEN", joinColumns = {
			@JoinColumn(name = "MA_DON_HANG", referencedColumnName = "MA_DON_HANG") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_NHAN_VIEN", referencedColumnName = "MA_NHAN_VIEN", unique = true) })
	private Employee staffId;

	/******************************************************************************/

	@OneToOne
	@JoinTable(name = "DONHANG_GIOHANG", joinColumns = {
			@JoinColumn(name = "MA_DON_HANG", referencedColumnName = "MA_DON_HANG") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_GIO_HANG", referencedColumnName = "MA_GIO_HANG", unique = true) })
	private Cart cartId;

	/******************************************************************************/

	public Order() {}

	public Order(int orderId, String payment, boolean isPay, boolean isDelivery, String addressDelivery,
			String phoneDelivery, Customer customerId, Employee staffId, Cart cartId) {
		this.orderId = orderId;
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

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public Employee getStaff() {
		return staffId;
	}

	public void setStaff(Employee staffId) {
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
