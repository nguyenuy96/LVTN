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

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TAI_KHOAN")
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@Column(name = "MA_TAI_KHOAN", nullable = false, unique = true)
	private int accountId;

	/******************************************************************************/
	@JsonProperty("username")
	@Column(name = "TAI_KHOAN", nullable = false, unique = true)
	private String username;

	/******************************************************************************/

	@JsonProperty("password")
	@Column(name = "MAT_KHAU", nullable = false, unique = true)
	private String password;

	/******************************************************************************/

	@OneToOne
	@JoinTable(name = "PHAN_QUYEN_TAI_KHOAN", joinColumns = {
			@JoinColumn(name = "MA_TAI_KHOAN", referencedColumnName = "MA_TAI_KHOAN") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_PHAN_QUYEN", referencedColumnName = "MA_PHAN_QUYEN") })
	private Role role;

	/******************************************************************************/

	public Account() {
	}

	public Account(int accountId, String username, String password, Role role) {
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.role = role;
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

	public Role getAccountRole() {
		return role;
	}

	public void setAccountRole(Role role) {
		this.role = role;
	}

	/******************************************************************************/

	@Override
	public String toString() {
		return this.username + this.getPassword();
	}
}
