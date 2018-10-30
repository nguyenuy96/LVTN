package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "XUAT_XU")
public class Country implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_QUOC_GIA", nullable = false, unique = true)
	private int countryId;

	/******************************************************************************/
	
	@Column(name = "QUOC_GIA", nullable = false, unique = true)
	private String countryName;

	/******************************************************************************/
	
	public Country() { }

	public Country(int countryId, String countryName) {
		this.countryId = countryId;
		this.countryName = countryName;
	}

	/******************************************************************************/
	
	public int getCountryId() {
		return countryId;
	}

	public void setCountryid(int countryId) {
		this.countryId = countryId;
	}

	/******************************************************************************/
	
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}
