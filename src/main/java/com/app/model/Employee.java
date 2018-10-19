package com.app.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "NHAN_VIEN")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_NHAN_VIEN", nullable = false, unique = true)
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
	/******************************************************************************/
	@Column(name = "QUOC_TICH", nullable = false)
	private String nationality;

	/******************************************************************************/
	@Column(name = "CHUNG_MINH_THU", nullable = false, unique = true)
	private String identification;
	/******************************************************************************/
	@Column(name = "DIA_CHI", nullable = false)
	private String address;

	/******************************************************************************/

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "TAI_KHOAN_NHAN_VIEN", joinColumns = {
			@JoinColumn(name = "MA_NHAN_VIEN", referencedColumnName = "MA_NHAN_VIEN") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_TAI_KHOAN", referencedColumnName = "MA_TAI_KHOAN", unique = true) })
	private Account accountId;

	/******************************************************************************/

	public Employee() {
	}

	public Employee(int staffId, String name, String gender, String phoneNumber, String nationality,
			String identification, String address, Account accountId) {
		this.staffId = staffId;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.nationality = nationality;
		this.identification = identification;
		this.address = address;
		this.accountId = accountId;
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

	public Account getAccount() {
		return accountId;
	}

	public void setAccount(Account accountId) {
		this.accountId = accountId;
	}

	/******************************************************************************/
	@JsonManagedReference
	@OneToMany(mappedBy = "staffId")
	private Set<ImportRepository> importRepositories;

	public Set<ImportRepository> getImportRepositories() {
		return importRepositories;
	}

	public void setImportRepositories(Set<ImportRepository> importRepositories) {
		this.importRepositories = importRepositories;
	}

	/******************************************************************************/

	@JsonManagedReference
	@OneToMany(mappedBy = "staffId")
	private Set<ExportRepository> exportRepositories;

	public Set<ExportRepository> getExportRepositories() {
		return exportRepositories;
	}

	public void setExportRepositories(Set<ExportRepository> exportRepositories) {
		this.exportRepositories = exportRepositories;
	}
}
