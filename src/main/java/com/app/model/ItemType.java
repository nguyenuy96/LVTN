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
@Table(name = "ITEM_TYPE")
public class ItemType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TYPE_ID")
	private int TYPE_ID;
	@Column(name = "TYPE_NAME")
	private String TYPE_NAME;
	@Column(name = "LAST_UPD_USR")
	private int LAST_UPD_USR;
	@Column(name = "LAST_UPD_DT")
	private Date LAST_UPD_DT;

	public ItemType(int type_id) {
		this.TYPE_ID = type_id;
	}

	public ItemType(int type_id, String type_name, int last_upd_usr, Date last_upd_dt) {
		this.TYPE_ID = type_id;
		this.TYPE_NAME = type_name;
		this.LAST_UPD_USR = last_upd_usr;
		this.LAST_UPD_DT = last_upd_dt;
	}

	public int getTYPE_ID() {
		return TYPE_ID;
	}

	public void setTYPE_ID(int type_id) {
		TYPE_ID = type_id;
	}

	public String getTYPE_NAME() {
		return TYPE_NAME;
	}

	public void setTYPE_NAME(String type_name) {
		TYPE_NAME = type_name;
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
