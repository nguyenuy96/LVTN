package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private int empId;

	/******************************************************************************/

	@Column(name = "HO_TEN")
	private String name;

	/******************************************************************************/
	@Column(name = "GIOI_TINH")
	private String gender;

	/******************************************************************************/
	@Column(name = "SO_DIEN_THOAI")
	private String phoneNumber;
	/******************************************************************************/
	@Column(name = "QUOC_TICH")
	private String nationality;

	/******************************************************************************/
	@Column(name = "CHUNG_MINH_THU")
	private String identification;
	/******************************************************************************/
	@Column(name = "DIA_CHI")
	private String address;

	/******************************************************************************/

	public Employee() {
	}

	public Employee(int empId, String name, String gender, String phoneNumber, String nationality,
			String identification, String address) {
		this.empId = empId;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.nationality = nationality;
		this.identification = identification;
		this.address = address;
	}

	/******************************************************************************/

	public int getEmplId() {
		return empId;
	}

	public void setEmplId(int empId) {
		this.empId = empId;
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

//	public Account getAccount() {
//		return accountId;
//	}
//
//	public void setAccount(Account accountId) {
//		this.accountId = accountId;
//	}

	/******************************************************************************/
//	@JsonManagedReference
//	@OneToMany(mappedBy = "empId", fetch = FetchType.EAGER)
//	private Set<ImportRepository> importRepositories;
//
//	public Set<ImportRepository> getImportRepositories() {
//		return importRepositories;
//	}
//
//	public void setImportRepositories(Set<ImportRepository> importRepositories) {
//		this.importRepositories = importRepositories;
//	}

	/******************************************************************************/

//	@JsonManagedReference
//	@OneToMany(mappedBy = "empId", fetch = FetchType.EAGER)
//	private Set<ExportRepository> exportRepositories;
//
//	public Set<ExportRepository> getExportRepositories() {
//		return exportRepositories;
//	}
//
//	public void setExportRepositories(Set<ExportRepository> exportRepositories) {
//		this.exportRepositories = exportRepositories;
//	}
}
