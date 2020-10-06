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
@Table(name = "exporting")
public class ExportReceipt implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer exportingRecId;

	@ManyToOne
	@JoinTable(name = "warehouse_of_exporting", joinColumns = {
			@JoinColumn(name = "exportingRecId", referencedColumnName = "exportingRecId") }, inverseJoinColumns = {
					@JoinColumn(name = "warehouseId", referencedColumnName = "warehouseId") })
	private Warehouse warehouse;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "exporting_owner", joinColumns = {
			@JoinColumn(name = "exportingRecId", referencedColumnName = "exportingRecId") }, inverseJoinColumns = {
					@JoinColumn(name = "employeeId", referencedColumnName = "employeeId") })
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
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
	
	public ExportReceipt(Integer exportingRecId) {
		this.exportingRecId = exportingRecId;
	}

	public ExportReceipt(int exportingRecId, Warehouse warehouse, Employee employee, Date exportDate) {
		this.exportingRecId = exportingRecId;
		this.warehouse = warehouse;
		this.employee = employee;
		this.exportDate = exportDate;
	}

	public Integer getExportingRecId() {
		return exportingRecId;
	}

	public void setExportingRecId(Integer exportingRecId) {
		this.exportingRecId = exportingRecId;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Date exportDate;

	public Date getExportDate() {
		return exportDate;
	}

	public void setExportDate(Date exportDate) {
		this.exportDate = exportDate;
	}
	
}
