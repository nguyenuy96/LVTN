package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "PHAN_QUYEN")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@Column(name = "MA_PHAN_QUYEN", nullable = false, unique = true)
	private Integer roleId;

	/******************************************************************************/
	@JsonProperty("account_role")
	@Column(name = "LOAI_TAI_KHOAN", nullable = false, unique = true)
	private String role;

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

	public Role(Integer roleId, String role, String searchName) {
		this.roleId = roleId;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
