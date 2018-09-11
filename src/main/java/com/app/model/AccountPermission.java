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
@Table(name = "LOAI_TAI_KHOAN")
public class AccountPermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int permissionId;
	
	/******************************************************************************/
	
	@Column(name = "LOAI_TAI_KHOAN", nullable = false, unique = true)
	private String permissionType;
	
	/******************************************************************************/
	
	public AccountPermission(int permisstionId) {
		this.permissionId = permisstionId;
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
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
