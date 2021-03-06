package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "KHACH_HANG")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_KHACH_HANG", nullable = false, unique = true)
	private int customerId;

	/******************************************************************************/

	@Column(name = "HO_TEN")
	private String name;

	/******************************************************************************/

	@Column(name = "SO_DIEN_THOAI")
	private String phoneNumber;

	/******************************************************************************/

	@Column(name = "DIA_CHI")
	private String address;

	/******************************************************************************/
//
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinTable(name = "TAI_KHOAN_KHACH_HANG", joinColumns = {
//			@JoinColumn(name = "MA_KHACH_HANG", referencedColumnName = "MA_KHACH_HANG") }, inverseJoinColumns = {
//					@JoinColumn(name = "MA_TAI_KHOAN", referencedColumnName = "MA_TAI_KHOAN", unique = true) })
//	private Account accountId;

	/******************************************************************************/

	public Customer() {
	}

	public Customer(int customerId, String name, String phoneNumber, String address) {
		this.customerId = customerId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
//		this.accountId = accountId;
	}

	/******************************************************************************/

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/******************************************************************************/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/******************************************************************************/

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/******************************************************************************/

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/******************************************************************************/
//
//	public Account getAccount() {
//		return accountId;
//	}
//
//	public void setAccount(Account accountId) {
//		this.accountId = accountId;
//	}

	/******************************************************************************/

}
