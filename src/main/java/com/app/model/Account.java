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
	private String userLogin;

	/******************************************************************************/

	@Column(name = "MAT_KHAU", nullable = false, unique = true)
	private String password;

	/******************************************************************************/

	@OneToOne
	@JoinTable(name = "PHAN_QUYEN_TAI_KHOAN", joinColumns = {
			@JoinColumn(name = "MA_TAI_KHOAN", referencedColumnName = "MA_TAI_KHOAN") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_PHAN_QUYEN", referencedColumnName = "MA_PHAN_QUYEN") })
	private AccountPermission permissionId;

	/******************************************************************************/

	public Account() {
	}

	public Account(int accountId, String userLogin, String password, AccountPermission permissionId) {
		this.accountId = accountId;
		this.userLogin = userLogin;
		this.password = password;
		this.permissionId = permissionId;
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

	public AccountPermission getPermission() {
		return permissionId;
	}

	public void setPermission(AccountPermission permissionId) {
		this.permissionId = permissionId;
	}

	/******************************************************************************/

	@Override
	public String toString() {
		return this.userLogin + this.getPassword();
	}
}
