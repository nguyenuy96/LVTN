package com.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_OBJ")
public class CustomerObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUS_OBJ_ID")
	private int CUS_OBJ_ID;
	@Column(name = "CUS_OBJ_NAME")
	private String CUS_OBJ_NAME;
	@Column(name = "LAST_UPD_USR")
	private int LAST_UPD_USR;
	@Column(name = "LAST_UPD_DT")
	private Date LAST_UPD_DT;

	public CustomerObject(int cus_obj_id) {
		this.CUS_OBJ_ID = cus_obj_id;
	}

	public CustomerObject(int cus_obj_id, String cus_obj_name, int last_upd_usr, Date last_upd_dt) {
		this.CUS_OBJ_ID = cus_obj_id;
		this.CUS_OBJ_NAME = cus_obj_name;
		this.LAST_UPD_USR = last_upd_usr;
		this.LAST_UPD_DT = last_upd_dt;
	}

	public int getCUS_OBJ_ID() {
		return CUS_OBJ_ID;
	}

	public void setCUS_OBJ_ID(int cus_obj_id) {
		CUS_OBJ_ID = cus_obj_id;
	}

	public String getCUS_OBJ_NAME() {
		return CUS_OBJ_NAME;
	}

	public void setCUS_OBJ_NAME(String cus_obj_name) {
		CUS_OBJ_NAME = cus_obj_name;
	}

	public int getLAST_UPD_USR() {
		return LAST_UPD_USR;
	}

	public void setLAST_UPD_USR(int last_upd_usr) {
		LAST_UPD_USR = last_upd_usr;
	}

	public Date getLAST_UPD_DT() {
		return LAST_UPD_DT;
	}

	public void setLAST_UPD_DT(Date last_upd_dt) {
		LAST_UPD_DT = last_upd_dt;
	}

}
