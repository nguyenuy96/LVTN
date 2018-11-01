package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PHAN_QUYEN")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "MA_PHAN_QUYEN", nullable = false, unique = true)
	private Integer roleId;

	/******************************************************************************/

	@Column(name = "LOAI_TAI_KHOAN", nullable = false, unique = true)
	private String roleName;

	/******************************************************************************/

	@Column(name = "TEN_HIEN_THI")
	private String searchName;

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public Role() {
	}

	public Role(Integer roleId) {
		this.roleId = roleId;
	}

	public Role(Integer roleId, String roleName, String searchName) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.searchName = searchName;
	}

	/******************************************************************************/

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/******************************************************************************/

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
