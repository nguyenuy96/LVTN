package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAI_KHOAN")
public class Accounts implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int ACCOUNT_ID;
	
	/******************************************************************************/
	@Column(name = "TAI_KHOAN", nullable = false, unique = true)
	private String USER_LOGIN;
	
	/******************************************************************************/
	
	@Column(name = "MAT_KHAU", nullable = false, unique = true)
	private String PASS_WORD;

	public Accounts(int user_id) {
		this.ACCOUNT_ID = user_id;
	}

	public Accounts(int user_id, String user_login, String pass_word) {
		this.ACCOUNT_ID = user_id;
		this.USER_LOGIN = user_login;
		this.PASS_WORD = pass_word;
	}

	public int getUSER_ID() {
		return ACCOUNT_ID;
	}

	public void setUSER_ID(int user_id) {
		ACCOUNT_ID = user_id;
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
	private AccountPermission PERMISSION_ID;

	public AccountPermission getPERMISSION_ID() {
		return PERMISSION_ID;
	}

	public void setPERMISSION_ID(AccountPermission permission_id) {
		PERMISSION_ID = permission_id;
	}

	@OneToOne
	@JoinColumn(name = "CUSTOMER")
	private Customers CUSTOMER;

	public Customers getCUSTOMER() {
		return CUSTOMER;
	}

	public void setCUSTOMER(Customers customer) {
		this.CUSTOMER = customer;
	}
	
	@OneToOne
	@JoinColumn(name = "STAFF")
	private Staffs STAFF;
	
	public Staffs getSTAFF() {
		return STAFF;
	}
	
	public void setSTAFF(Staffs staff) {
		this.STAFF = staff;
	}

}
