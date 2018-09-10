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
@Table(name = "NHAN_VIEN")
public class Staff implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int staffId;
	
	/******************************************************************************/
	
	@Column(name = "HO_TEN", nullable = false)
	private String name;
	
	/******************************************************************************/
	
	@Column(name = "GIOI_TINH", nullable = false)
	private String gender;
	
	/******************************************************************************/
	
	@Column(name = "SO_DIEN_THOAI", nullable = false, unique = true)
	private String phoneNumber;
	
	
	@Column(name = "QUOC_TICH", nullable = false)
	private String nationality;
	
	/******************************************************************************/
	
	@Column(name = "CHUNG_MINH_THU", nullable = false, unique = true)
	private String identification;

	/******************************************************************************/
	
	@Column(name = "DIA_CHI", nullable = false)
	private String address;
	
	public Staff(int staffId, String name, String gender, String phoneNumber,
			String nationality, String identification, String address) {
		this.staffId = staffId;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.nationality = nationality;
		this.identification = identification;
		this.address = address;
	}

	/******************************************************************************/
	
	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	/******************************************************************************/
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/******************************************************************************/
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/******************************************************************************/
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/******************************************************************************/
	
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/******************************************************************************/
	
	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	/******************************************************************************/
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	/******************************************************************************/
	
	@OneToOne
	@JoinColumn(name = "TAI_KHOAN")
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	/******************************************************************************/
	
	@OneToOne(mappedBy = "staff")
	private Bill bill;

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

}