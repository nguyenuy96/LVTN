package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAN_NANG")
public class Weight implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int WEIGHT_ID;
	
	@Column(name = "CAN_NANG", nullable = false, unique = true)
	private float WEIGHT;
	
	public Weight (int weight_id) {
		this.WEIGHT_ID = weight_id;
	}
	
	public Weight(int weight_id, float weight) {
		this.WEIGHT_ID = weight_id;
		this.WEIGHT = weight;
	}
	
	public int getWEIGHT_ID() {
		return WEIGHT_ID;
	}
	
	public void setWEIGHT_ID(int weight_id) {
		this.WEIGHT_ID = weight_id;
	}
	
	public float getWEIGHT() {
		return WEIGHT;
	}
	
	public void setWEIGHT(float weight) {
		this.WEIGHT = weight;
	}
	
}
