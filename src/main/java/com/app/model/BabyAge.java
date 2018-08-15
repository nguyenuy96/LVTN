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
@Table(name = "BABY_AGE")
public class BabyAge implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AGE_ID")
	private int AGE_ID;
	@Column(name = "AGE")
	private int AGE;

	public BabyAge(int age_id) {
		this.AGE_ID = age_id;
	}

	public BabyAge(int age_id, int age, int last_upd_usr, Date last_upd_dt) {
		this.AGE_ID = age_id;
		this.AGE = age;
		this.LAST_UPD_USR = last_upd_usr;
		this.LAST_UPD_DT = last_upd_dt;
	}

	public int getAGE_ID() {
		return AGE_ID;
	}

	public void setAGE_ID(int age_id) {
		AGE_ID = age_id;
	}

	public int getAGE() {
		return AGE;
	}

	public void setAGE(int age) {
		AGE = age;
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

	@Column(name = "LAST_UPD_USR")
	private int LAST_UPD_USR;
	@Column(name = "LAST_UPD_DT")
	private Date LAST_UPD_DT;
}
