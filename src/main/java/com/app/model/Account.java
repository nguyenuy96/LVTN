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
@Table(name = "TAI_KHOAN")
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int accountId;
	
	/******************************************************************************/
	@Column(name = "TAI_KHOAN", nullable = false, unique = true)
	private String userLogin;
	
	/******************************************************************************/
	
	@Column(name = "MAT_KHAU", nullable = false, unique = true)
	private String password;

	/******************************************************************************/
	
	public Account(int accountId) {
		this.accountId = accountId;
	}

	public Account(int accountId, String userLogin, String password, AccountPermission permission,
			Customer customer, Staff staff) {
		super();
		this.accountId = accountId;
		this.userLogin = userLogin;
		this.password = password;
		this.permission = permission;
		this.customer = customer;
		this.staff = staff;
	}

	/******************************************************************************/
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/******************************************************************************/
	
	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	/******************************************************************************/
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/******************************************************************************/
	
	@OneToOne
	@JoinColumn(name = "LOAI_TAI_KHOAN", nullable = false, unique = true)
	private AccountPermission permission;

	public AccountPermission getPermission() {
		return permission;
	}

	public void setPermission(AccountPermission permissionId) {
		this.permission = permissionId;
	}

	/******************************************************************************/
	
	@OneToOne(mappedBy = "account")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/******************************************************************************/
	
	@OneToOne(mappedBy = "account")
	private Staff staff;
	
	public Staff getStaff() {
		return staff;
	}
	
	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}
