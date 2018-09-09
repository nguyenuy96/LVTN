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
@Table(name = "NHAN_VIEN")
public class Staffs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int STAFF_ID;
	
	/******************************************************************************/
	
	@Column(name = "HO_TEN", nullable = false)
	private String NAME;
	
	/******************************************************************************/
	
	@Column(name = "GIOI_TINH", nullable = false)
	private String GENDER;
	
	/******************************************************************************/
	
	@Column(name = "SO_DIEN_THOAI", nullable = false, unique = true)
	private String PHONE_NUMBER;
	
	
	@Column(name = "QUOC_TICH", nullable = false)
	private String NATIONALITY;
	
	/******************************************************************************/
	
	@Column(name = "CHUNG_MINH_THU", nullable = false, unique = true)
	private String IDENTIFICATION;

	/******************************************************************************/
	
	@Column(name = "DIA_CHI", nullable = false)
	private String ADDRESS;
	
	public Staffs(int staff_id, String name, String gender, String phone_number,
			String nationality, String identification, String address) {
		this.STAFF_ID = staff_id;
		this.NAME = name;
		this.GENDER = gender;
		this.PHONE_NUMBER = phone_number;
		this.NATIONALITY = nationality;
		this.IDENTIFICATION = identification;
		this.ADDRESS = address;
	}

	/******************************************************************************/
	
	public int getPERSONAL_ID() {
		return STAFF_ID;
	}

	public void setPERSONAL_ID(int staff_id) {
		STAFF_ID = staff_id;
	}

	/******************************************************************************/
	
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String name	) {
		NAME = name;
	}

	/******************************************************************************/
	
	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gender) {
		GENDER = gender;
	}

	/******************************************************************************/
	
	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}

	public void setPHONE_NUMBER(String phone_number) {
		PHONE_NUMBER = phone_number;
	}

	/******************************************************************************/
	
	public String getNATIONALITY() {
		return NATIONALITY;
	}

	public void setNATIONALITY(String nationality) {
		NATIONALITY = nationality;
	}

	/******************************************************************************/
	
	public String getIDENTIFICATION() {
		return IDENTIFICATION;
	}

	public void setIDENTIFICATION(String identification) {
		IDENTIFICATION = identification;
	}

	/******************************************************************************/
	
	public String getADDRESS() {
		return ADDRESS;
	}
	
	public void setADDRESS(String address) {
		this.ADDRESS = address;
	}
	
	/******************************************************************************/
	
	@OneToOne(mappedBy = "STAFF")
	private Accounts ACCOUNT;

	public Accounts getACCOUNT_ID() {
		return ACCOUNT;
	}

	public void setACCOUNT_ID(Accounts account) {
		this.ACCOUNT = account;
	}

}
