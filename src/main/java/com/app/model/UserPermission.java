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
@Table(name = "USER_PERMISSION")
public class UserPermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERMISSON_ID", nullable = false, unique = true)
	private int PERMISSION_ID;
	@Column(name = "PERMISSION_TYPE")
	private String PERMISSION_TYPE;
	@Column(name = "LAST_UPD_USR")
	private String LAST_UPD_USR;
	@Column(name = "LAST_UPD_DT")
	private Date LAST_UPD_DT;

	public UserPermission(int permission_id, String permission_type, String last_upd_usr, Date last_upd_dt) {
		this.PERMISSION_ID = permission_id;
		this.PERMISSION_TYPE = permission_type;
		this.LAST_UPD_USR = last_upd_usr;
		this.LAST_UPD_DT = last_upd_dt;
	}

	public int getPERMISSION_ID() {
		return PERMISSION_ID;
	}

	public void setPERMISSION_ID(int permission_id) {
		PERMISSION_ID = permission_id;
	}

	public String getPERMISSION_TYPE() {
		return PERMISSION_TYPE;
	}

	public void setPERMISSION_TYPE(String permission_type) {
		PERMISSION_TYPE = permission_type;
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

	@OneToOne(mappedBy = "PERMISSION_ID")
	private UserModel USER_ID;

	public UserModel getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(UserModel user_id) {
		USER_ID = user_id;
	}

}
