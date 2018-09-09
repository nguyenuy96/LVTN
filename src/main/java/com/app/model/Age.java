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
	@Column(name = "ID", nullable = false, unique = true)
	private int AGE_ID;

	@Column(name = "DO_TUOI", nullable = false, unique = true)
	private int AGE;

	public Age(int age_id) {
		this.AGE_ID = age_id;
	}

	public Age(int age_id, int age) {
		this.AGE_ID = age_id;
		this.AGE = age;
	}

	public int getAGE_ID() {
		return AGE_ID;
	}

	public void setAGE_ID(int age_id) {
		this.AGE_ID = age_id;
	}
	
	public int getAGE() {
		return AGE;
	}
	
	public void seAGE(int age) {
		this.AGE = age;
	}

}
