package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PHAN_QUYEN")
public class AccountPermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_PHAN_QUYEN", nullable = false, unique = true)
	private int permissionId;
	
	/******************************************************************************/
	
	@Column(name = "LOAI_TAI_KHOAN", nullable = false, unique = true)
	private String permissionType;
	
	/******************************************************************************/
	
	public AccountPermission() {}
	
	public AccountPermission(int permissionId) {
		this.permissionId = permissionId;
	}
	
	public AccountPermission(int permissionId, String permissionType) {
		this.permissionId = permissionId;
		this.permissionType = permissionType;
	}

	/******************************************************************************/
	
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	
	/******************************************************************************/
	
	public String getPermissionType() {
		return permissionType;
	}
	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	/******************************************************************************/

	@OneToOne(mappedBy = "permissionId")
	private Account accountId;

	public Account getAccountId() {
		return accountId;
	}

	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}
}
