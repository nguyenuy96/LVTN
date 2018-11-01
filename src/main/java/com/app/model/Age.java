package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DO_TUOI")
public class Age implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_DO_TUOI", nullable = false, unique = true)
	private int ageId;

	/******************************************************************************/

	@Column(name = "TUOI_BAT_DAU")
	private int startAge;

	/******************************************************************************/

	@Column(name = "TUOI_KET_THUC")
	private int endAge;

	/******************************************************************************/
	public Age() {
	}

	public Age(int age_id, int startAge, int endAge) {
		this.ageId = age_id;
		this.startAge = startAge;
		this.endAge = endAge;
	}

	/******************************************************************************/

	public int getAgeId() {
		return ageId;
	}

	public void setAgeId(int ageId) {
		this.ageId = ageId;
	}

	/******************************************************************************/

	public int getStartAge() {
		return startAge;
	}

	public void setStartAge(int startAge) {
		this.startAge = startAge;
	}

	/******************************************************************************/

	public int getEndAge() {
		return endAge;
	}

	public void setEndAge(int endAge) {
		this.endAge = endAge;
	}

	/******************************************************************************/

}
