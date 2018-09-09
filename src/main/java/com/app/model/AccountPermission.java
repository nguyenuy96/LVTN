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
@Table(name = "LOAI_TAI_KHOAN")
public class AccountPermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int PERMISSION_ID;
	
	/******************************************************************************/
	
	@Column(name = "LOAI_TAI_KHOAN")
	private String PERMISSION_TYPE;
	
	/******************************************************************************/

	public AccountPermission(int permission_id, String permission_type, String last_upd_usr, Date last_upd_dt) {
		this.PERMISSION_ID = permission_id;
		this.PERMISSION_TYPE = permission_type;
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

	@OneToOne(mappedBy = "PERMISSION_ID")
	private Accounts USER_ID;

	public Accounts getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(Accounts user_id) {
		USER_ID = user_id;
	}

}
