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
@Table(name = "DO_TUOI")
public class Age implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int ageId;

	/******************************************************************************/
	
	@Column(name = "DO_TUOI", nullable = false, unique = true)
	private int age;

	/******************************************************************************/
	
	public Age(int ageId) {
		this.ageId = ageId;
	}

	public Age(int age_id, int age) {
		this.ageId = age_id;
		this.age = age;
	}

	/******************************************************************************/
	
	public int getAgeId() {
		return ageId;
	}

	public void setAgeId(int ageId) {
		this.age = ageId;
	}
	
	/******************************************************************************/
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	/******************************************************************************/
	
	@JsonManagedReference
	@OneToMany(mappedBy = "ageId")
	private Set<Item> item;

	public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}
	
}
