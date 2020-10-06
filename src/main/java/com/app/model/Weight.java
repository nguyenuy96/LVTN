package com.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weight")
public class Weight implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long weightId;

	private double startWeight;

	private double endWeight;

	private String size;

	public Weight() {
	}

	public Weight(Long weightId, int startWeight, int endWeight, String size) {
		this.weightId = weightId;
		this.startWeight = startWeight;
		this.endWeight = endWeight;
		this.size = size;
	}

	public Long getWeightId() {
		return weightId;
	}

	public void setWeightId(Long weight_id) {
		this.weightId = weight_id;
	}

	public double getStartWeight() {
		return startWeight;
	}

	public void setStartWeight(double startWeight) {
		this.startWeight = startWeight;
	}

	public double getEndWeight() {
		return endWeight;
	}

	public void setEndWeight(double endWeight) {
		this.endWeight = endWeight;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
}
