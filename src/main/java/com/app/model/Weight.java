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
public class Weight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_CAN_NANG", nullable = false, unique = true)
	private int weightId;

	/******************************************************************************/

	@Column(name = "CAN_NANG_BAT_DAU")
	private int startWeight;

	/******************************************************************************/

	@Column(name = "CAN_NANG_KET_THUC")
	private int endWeight;

	/******************************************************************************/

	@Column(name = "KICH_THUOC")
	private String size;

	/******************************************************************************/
	public Weight() {
	}

	public Weight(int weightId, int startWeight, int endWeight, String size) {
		this.weightId = weightId;
		this.startWeight = startWeight;
		this.endWeight = endWeight;
		this.size = size;
	}

	/******************************************************************************/

	public int getWeightId() {
		return weightId;
	}

	public void setWeightId(int weight_id) {
		this.weightId = weight_id;
	}

	/******************************************************************************/

	public int getStartWeight() {
		return startWeight;
	}

	public void setStartWeight(int startWeight) {
		this.startWeight = startWeight;
	}

	/******************************************************************************/

	public int getEndWeight() {
		return endWeight;
	}

	public void setEndWeight(int endWeight) {
		this.endWeight = endWeight;
	}

	/******************************************************************************/

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	/******************************************************************************/
	
}
