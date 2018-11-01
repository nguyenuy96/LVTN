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
@Table(name = "TAI_KHOAN")
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_TAI_KHOAN", nullable = false, unique = true)
	private int accountId;

	/******************************************************************************/
	@Column(name = "TAI_KHOAN", nullable = false, unique = true)
	private String username;

	/******************************************************************************/

	@Column(name = "MAT_KHAU", nullable = false, unique = true)
	private String password;

	/******************************************************************************/

	@OneToOne
	@JoinTable(name = "PHAN_QUYEN_TAI_KHOAN", joinColumns = {
			@JoinColumn(name = "MA_TAI_KHOAN", referencedColumnName = "MA_TAI_KHOAN") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_PHAN_QUYEN", referencedColumnName = "MA_PHAN_QUYEN") })
	private Role role;

	/******************************************************************************/

	@OneToOne
	@JoinTable(name = "TAI_KHOAN_KHACH_HANG", joinColumns = {
			@JoinColumn(name = "MA_TAI_KHOAN", referencedColumnName = "MA_TAI_KHOAN") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_KHACH_HANG", referencedColumnName = "MA_KHACH_HANG") })
	private Customer customer;

	@OneToOne
	@JoinTable(name = "TAI_KHOAN_NHAN_VIEN", joinColumns = {
			@JoinColumn(name = "MA_TAI_KHOAN", referencedColumnName = "MA_TAI_KHOAN") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_NHAN_VIEN", referencedColumnName = "MA_NHAN_VIEN") })
	private Employee employee;

	public Account() {
	}

	public Account(int accountId, String username, String password, Role role, Employee employee, Customer customer) {
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.employee = employee;
		this.customer = customer;
	}

	/******************************************************************************/

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/******************************************************************************/

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/******************************************************************************/

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/******************************************************************************/

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	/******************************************************************************/

}
