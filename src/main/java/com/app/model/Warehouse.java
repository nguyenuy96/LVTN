package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KHO_HANG")
public class Warehouse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_KHO_HANG", nullable = false, unique = true)
	private int warehouseId;

	/******************************************************************************/

	@Column(name = "TEN_KHO_HANG", nullable = false)
	private String warehouseName;

	/******************************************************************************/

	public Warehouse() {
	}

	public Warehouse(int warehouseId, String warehouseName) {
		this.warehouseId = warehouseId;
		this.warehouseName = warehouseName;
	}

	/******************************************************************************/

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	/******************************************************************************/

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	/******************************************************************************/
}
