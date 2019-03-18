package com.app.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "XUAT_KHO")
public class ExportReceipt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_XUAT_KHO", nullable = false, unique = true)
	private Integer exportRecId;
	
	/******************************************************************************/
	
	@ManyToOne
	@JoinTable(name = "XUAT_KHO_KHO_HANG", joinColumns = {
			@JoinColumn(name = "MA_XUAT_KHO", referencedColumnName = "MA_XUAT_KHO") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_KHO_HANG", referencedColumnName = "MA_KHO_HANG") })
	private Warehouse warehouse;

	/******************************************************************************/
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "NHAN_VIEN_XUAT_KHO", joinColumns = {
			@JoinColumn(name = "MA_XUAT_KHO", referencedColumnName = "MA_XUAT_KHO") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_NHAN_VIEN", referencedColumnName = "MA_NHAN_VIEN") })
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	/******************************************************************************/
	
	@OneToMany(mappedBy = "exportRecDetailId.exportReceipt", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<ExportRecDetail> exportRecDetail = new HashSet<ExportRecDetail>();
	
	
	public Set<ExportRecDetail> getExportRecDetail() {
		return exportRecDetail;
	}

	public void setExportRecDetail(Set<ExportRecDetail> exportRecDetail) {
		this.exportRecDetail = exportRecDetail;
	}

	public ExportReceipt() { }
	
	public ExportReceipt(Integer exportRecId) {
		this.exportRecId = exportRecId;
	}

	public ExportReceipt(int exportRecId, Warehouse warehouse,Employee employee, Date exportDate) {
		this.exportRecId = exportRecId;
		this.warehouse = warehouse;
		this.employee = employee;
		this.exportDate = exportDate;
	}

	/******************************************************************************/

	public Integer getExportRecId() {
		return exportRecId;
	}

	public void setExportRecId(Integer exportRecId) {
		this.exportRecId = exportRecId;
	}

	/******************************************************************************/

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	@Column(name = "NGAY_XUAT_KHO")
	public Date exportDate;

	public Date getExportDate() {
		return exportDate;
	}

	public void setExportDate(Date exportDate) {
		this.exportDate = exportDate;
	}
	
}
