package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(nullable = false, unique = true)
	private Long roleId;

	@Column(nullable = false, unique = true)
	private String roleName;

	@Column
	private String searchName;

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public Role() {
	}

	public Role(Long roleId) {
		this.roleId = roleId;
	}

	public Role(Long roleId, String roleName, String searchName) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.searchName = searchName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
