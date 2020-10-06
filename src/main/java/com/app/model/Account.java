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
@Table(name = "account")
public class Account implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long accountId;

	@Column(nullable = false, unique = true)
	private String userName;

	@Column(nullable = false, unique = true)
	private String password;

	@OneToOne
	@JoinTable(name = "role_of_account", joinColumns = {
			@JoinColumn(name = "accountId", referencedColumnName = "accountId") }, inverseJoinColumns = {
					@JoinColumn(name = "roleId", referencedColumnName = "roleId") })
	private Role role;

	@OneToOne
	@JoinTable(name = "account_of_customer", joinColumns = {
			@JoinColumn(name = "accountId", referencedColumnName = "accountId") }, inverseJoinColumns = {
					@JoinColumn(name = "customerId", referencedColumnName = "customerId") })
	private Customer customer;

	@OneToOne
	@JoinTable(name = "account_of_employee", joinColumns = {
			@JoinColumn(name = "accountId", referencedColumnName = "accountId") }, inverseJoinColumns = {
					@JoinColumn(name = "employeeId", referencedColumnName = "employeeId") })
	private Employee employee;

	public Account() {
	}

	public Account(Long accountId, String userName, String password, Role role, Employee employee, Customer customer) {
		this.accountId = accountId;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.employee = employee;
		this.customer = customer;
	}


	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

}
