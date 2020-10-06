package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "age")
public class Age implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ageId;

	private Long startAge;

	private Long endAge;

	public Age() {
	}

	public Age(Long ageId, Long startAge, Long endAge) {
		this.ageId = ageId;
		this.startAge = startAge;
		this.endAge = endAge;
	}

	public Long getAgeId() {
		return ageId;
	}

	public void setAgeId(Long ageId) {
		this.ageId = ageId;
	}

	public Long getStartAge() {
		return startAge;
	}

	public void setStartAge(Long startAge) {
		this.startAge = startAge;
	}

	public Long getEndAge() {
		return endAge;
	}

	public void setEndAge(Long endAge) {
		this.endAge = endAge;
	}

}
