package com.app.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private int weightId;
	
	/******************************************************************************/
	
	@Column(name = "CAN_NANG", nullable = false, unique = true)
	private float weight;
	
	/******************************************************************************/
	
	public Weight (int weightId) {
		this.weightId = weightId;
	}
	
	public Weight(int weightId, float weight) {
		this.weightId = weightId;
		this.weight = weight;
	}
	
	/******************************************************************************/
	
	public int getWeightId() {
		return weightId;
	}
	
	public void setWeightId(int weight_id) {
		this.weightId = weight_id;
	}

	/******************************************************************************/
	
	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	/******************************************************************************/
	
	@JsonManagedReference
	@OneToMany(mappedBy = "weightId")
	private Set<Item> item;

	public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}
	
}
