package com.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class UserModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", nullable = false, unique = true)
	private int USER_ID;
	@Column(name = "USER_LOGIN")
	private String USER_LOGIN;
	@Column(name = "PASS_WORD")
	private String PASS_WORD;
	@Column(name = "LAST_UPD_USR")
	private int LAST_UPD_USR;
	@Column(name = "LAST_UPD_DT")
	private Date LAST_UPD_DT;

	public UserModel(int user_id) {
		this.USER_ID = user_id;
	}

	public UserModel(int user_id, String user_login, String pass_word) {
		this.USER_ID = user_id;
		this.USER_LOGIN = user_login;
		this.PASS_WORD = pass_word;
	}

	public int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int user_id) {
		USER_ID = user_id;
	}

	public String getUSER_LOGIN() {
		return USER_LOGIN;
	}

	public void setUSER_LOGIN(String user_login) {
		USER_LOGIN = user_login;
	}

	public String getPASS_WORD() {
		return PASS_WORD;
	}

	public void setPASS_WORD(String pass_word) {
		PASS_WORD = pass_word;
	}

	@OneToOne
	@JoinColumn(name = "PERMISSION_ID")
	private UserPermission PERMISSION_ID;

	public UserPermission getPERMISSION_ID() {
		return PERMISSION_ID;
	}

	public void setPERMISSION_ID(UserPermission permission_id) {
		PERMISSION_ID = permission_id;
	}

	@OneToOne
	@JoinColumn(name = "PERSONAL_PRO")
	private UserContact PERSONAL_PRO;

	public UserContact getPERSONAL_PRO() {
		return PERSONAL_PRO;
	}

	public void setPERSONAL_PRO(UserContact personal_pro) {
		PERSONAL_PRO = personal_pro;
	}

}
