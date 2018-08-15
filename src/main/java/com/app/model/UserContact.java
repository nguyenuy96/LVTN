package com.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONAL_PRO")
public class UserContact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSONAL_ID", nullable = false, unique = true)
	private int PERSONAL_ID;
	@Column(name = "FIRST_NAME")
	private String FIRST_NAME;
	@Column(name = "LAST_NAME")
	private String LAST_NAME;
	@Column(name = "EMAIL")
	private String EMAIL;
	@Column(name = "PHONE_NUMBER")
	private String PHONE_NUMBER;
	@Column(name = "LAST_UPD_UST")
	private String LAST_UPD_USR;
	@Column(name = "LAST_UPD_DT")
	private Date LAST_UPD_DT;

	public UserContact(int personal_id, String first_name, String last_name, String email, String phone_number,
			String last_upd_usr, Date last_upd_dt) {
		this.PERSONAL_ID = personal_id;
		this.FIRST_NAME = first_name;
		this.LAST_NAME = last_name;
		this.EMAIL = email;
		this.PHONE_NUMBER = phone_number;
		this.LAST_UPD_USR = last_upd_usr;
		this.LAST_UPD_DT = last_upd_dt;
	}

	public int getPERSONAL_ID() {
		return PERSONAL_ID;
	}

	public void setPERSONAL_ID(int personal_id) {
		PERSONAL_ID = personal_id;
	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String first_name) {
		FIRST_NAME = first_name;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String last_name) {
		LAST_NAME = last_name;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String email) {
		EMAIL = email;
	}

	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}

	public void setPHONE_NUMBER(String phone_number) {
		PHONE_NUMBER = phone_number;
	}

	public String getLAST_UPD_USR() {
		return LAST_UPD_USR;
	}

	public void setLAST_UPD_USR(String last_upd_usr) {
		LAST_UPD_USR = last_upd_usr;
	}

	public Date getLAST_UPD_DT() {
		return LAST_UPD_DT;
	}

	public void setLAST_UPD_DT(Date last_upd_dt) {
		LAST_UPD_DT = last_upd_dt;
	}

	@OneToOne(mappedBy = "PERSONAL_PRO")
	private UserModel USER_ID;

	public UserModel getUSER_ID_CT() {
		return USER_ID;
	}

	public void setUSER_ID_CT(UserModel user_id) {
		USER_ID = user_id;
	}

}
