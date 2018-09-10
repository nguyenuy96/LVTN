package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	@Column(name = "ID", nullable = false, unique = true)
	private int countryId;

	/******************************************************************************/
	
	@Column(name = "QUOC_GIA", nullable = false, unique = true)
	private String country;

	/******************************************************************************/
	
	public Country(int countryId) {
		this.countryId = countryId;
	}

	public Country(int countryId, String country) {
		this.countryId = countryId;
		this.country = country;
	}

	/******************************************************************************/
	
	public int getCountryId() {
		return countryId;
	}

	public void setCountryid(int countryId) {
		this.countryId = countryId;
	}

	/******************************************************************************/
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	/******************************************************************************/
	
	@OneToOne(mappedBy = "country")
	private TradeMark tradeMark;

	public TradeMark getTradeMark() {
		return tradeMark;
	}

	public void setTradeMark(TradeMark tradeMark) {
		this.tradeMark = tradeMark;
	}
	
}
