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
@Table(name = "BABY_WEIGHT")
public class BabyWeight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WEIGHT_ID")
	private int WEIGHT_ID;
	@Column(name = "WEIGHT")
	private double WEIGHT;

	public BabyWeight(int weight_id) {
		this.WEIGHT_ID = weight_id;
	}

	public BabyWeight(int weight_id, double weight, int last_upd_usr, Date last_upd_dt) {
		this.WEIGHT_ID = weight_id;
		this.WEIGHT = weight;
		this.LAST_UPD_USR = last_upd_usr;
		this.LAST_UPD_DT = last_upd_dt;
	}

	public int getWEIGHT_ID() {
		return WEIGHT_ID;
	}

	public void setWEIGHT_ID(int weight_id) {
		WEIGHT_ID = weight_id;
	}

	public double getWEIGHT() {
		return WEIGHT;
	}

	public void setWEIGHT(double weight) {
		WEIGHT = weight;
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
