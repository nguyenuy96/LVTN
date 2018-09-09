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
@Table(name = "KHACH_HANG")
public class Customers implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int CUS_ID;
	
	/******************************************************************************/
	
	@Column(name = "HO_TEN", nullable = false)
	private String NAME;
	
	/******************************************************************************/
	
	@Column(name = "SO_DIEN_THOAI", nullable = false, unique = true)
	private String PHONE_NUM;
	
	/******************************************************************************/
	
	@Column(name = "DIA_CHI", nullable = false)
	private String ADDRESS;
	
	/******************************************************************************/
	
	public Customers(int cus_id) {
		this.CUS_ID = cus_id;
	}
	
	public Customers(int cus_id, String phone_num, String address) {
		this.CUS_ID = cus_id;
		this.PHONE_NUM = phone_num;
		this.ADDRESS = address;
	}
	
	/******************************************************************************/
	
	public int getCUS_ID() {
		return CUS_ID;
	}
	
	public void setCUS_ID(int cus_id) {
		this.CUS_ID = cus_id;
	}
	
	/******************************************************************************/
	
	public String getPHONE_NUM() {
		return PHONE_NUM;
	}
	
	public void setPHONE_NUM(String phone_num) {
		this.PHONE_NUM = phone_num;
	}
	
	/******************************************************************************/
	
	public String getNAME() {
		return NAME;
	}
	
	public void setNAME(String name) {
		this.NAME = name;
	}
	
	/******************************************************************************/
	
	@OneToOne(mappedBy = "CUSTOMER")
	private Accounts ACCOUNT;
	
	public Accounts getACCOUNT() {
		return ACCOUNT;
	}
	
	public void setACCOUNT(Accounts account) {
		this.ACCOUNT = account;
	}
	

}
