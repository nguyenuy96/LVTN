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
@Table(name = "order")
public class Order implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	private String payments;

	private boolean isPay;

	private boolean isDelivery;

	private String addressDelivery;

	private String phoneDelivery;

	private String orderState;

	@OneToOne
	@JoinTable(name = "customer_order", joinColumns = {
			@JoinColumn(name = "orderId", referencedColumnName = "orderId") }, inverseJoinColumns = {
					@JoinColumn(name = "customerId", referencedColumnName = "customerId") })
	private Customer customer;

	@OneToOne
	@JoinTable(name = "employee_order", joinColumns = {
			@JoinColumn(name = "orderId", referencedColumnName = "orderId") }, inverseJoinColumns = {
					@JoinColumn(name = "employeeId", referencedColumnName = "employeeId") })
	private Employee employee;

	@OneToOne
	@JoinTable(name = "orders_in_cart", joinColumns = {
			@JoinColumn(name = "orderId", referencedColumnName = "orderId") }, inverseJoinColumns = {
					@JoinColumn(name = "cartId", referencedColumnName = "cartId") })
	private Cart cart;

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

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getPayments() {
		return payments;
	}

	public void setPayment(String payments) {
		this.payments = payments;
	}

	public boolean isPay() {
		return isPay;
	}

	public void setPay(boolean isPay) {
		this.isPay = isPay;
	}

	public boolean isDelivery() {
		return isDelivery;
	}

	public void setDelivery(boolean isDelivery) {
		this.isDelivery = isDelivery;
	}

	public String getAddressDelivery() {
		return addressDelivery;
	}

	public void setAddressDelivery(String addressDelivery) {
		this.addressDelivery = addressDelivery;
	}

	public String getPhoneDelivery() {
		return phoneDelivery;
	}

	public void setPhoneDelivery(String phoneDelivery) {
		this.phoneDelivery = phoneDelivery;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

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
	

}
