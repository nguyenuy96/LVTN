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

	@Column(name = "LOAI_THANH_TOAN")
	private String payments;

	/******************************************************************************/

	@Column(name = "THANH_TOAN")
	private boolean isPay;

	/******************************************************************************/

	@Column(name = "GIAO_HANG")
	private boolean isDelivery;

	/******************************************************************************/

	@Column(name = "NOI_GIAO_HANG")
	private String addressDelivery;

	/******************************************************************************/

	@Column(name = "SDT_GIAO_HANG")
	private String phoneDelivery;

	/******************************************************************************/
	
	@Column(name = "TRANG_THAI")
	private String orderState;

	@OneToOne
	@JoinTable(name = "DONHANG_KHACHHANG", joinColumns = {
			@JoinColumn(name = "MA_DON_HANG", referencedColumnName = "MA_DON_HANG") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_KHACH_HANG", referencedColumnName = "MA_KHACH_HANG") })
	private Customer customer;

	/******************************************************************************/

	@OneToOne
	@JoinTable(name = "DONHANG_NHANVIEN", joinColumns = {
			@JoinColumn(name = "MA_DON_HANG", referencedColumnName = "MA_DON_HANG") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_NHAN_VIEN", referencedColumnName = "MA_NHAN_VIEN") })
	private Employee employee;

	/******************************************************************************/

	@OneToOne
	@JoinTable(name = "DONHANG_GIOHANG", joinColumns = {
			@JoinColumn(name = "MA_DON_HANG", referencedColumnName = "MA_DON_HANG") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_GIO_HANG", referencedColumnName = "MA_GIO_HANG") })
	private Cart cart;

	/******************************************************************************/

	public Order() {}

	public Order(int orderId, String payments, boolean isPay, boolean isDelivery, String addressDelivery,
			String phoneDelivery, Customer customer, Employee employee, Cart cart, String orderState) {
		this.orderId = orderId;
		this.payments = payments;
		this.isPay = isPay;
		this.isDelivery = isDelivery;
		this.addressDelivery = addressDelivery;
		this.phoneDelivery = phoneDelivery;
		this.customer = customer;
		this.employee = employee;
		this.cart = cart;
		this.orderState = orderState;
	}

	/******************************************************************************/

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/******************************************************************************/

	public String getPayments() {
		return payments;
	}

	public void setPayment(String payments) {
		this.payments = payments;
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
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/******************************************************************************/

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/******************************************************************************/

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	/******************************************************************************/
	

}
