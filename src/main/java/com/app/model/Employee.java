package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;

	private String name;

	private String gender;

	private String phoneNumber;

	private String nationality;

	private String identification;

	private String address;

	private boolean isActive = true;

	public Employee() {
	}

	public Employee(Long employeeId, String name, String gender, String phoneNumber, String nationality,
			String identification, String address) {
		this.employeeId = employeeId;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.nationality = nationality;
		this.identification = identification;
		this.address = address;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long empId) {
		this.employeeId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public Account getAccount() {
//		return accountId;
//	}
//
//	public void setAccount(Account accountId) {
//		this.accountId = accountId;
//	}

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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}
}
