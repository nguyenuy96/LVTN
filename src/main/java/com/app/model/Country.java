package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private int COUNTRY_ID;

	@Column(name = "QUOC_GIA", nullable = false, unique = true)
	private String COUNTRY;

	public Country(int country_id) {
		this.COUNTRY_ID = country_id;
	}

	public Country(int country_id, String country) {
		this.COUNTRY_ID = country_id;
		this.COUNTRY = country;
	}

	public int getCOUNTRY_ID() {
		return COUNTRY_ID;
	}

	public void setCOUNTRY_ID(int country_id) {
		COUNTRY_ID = country_id;
	}

	public String getCOUNTRY() {
		return COUNTRY;
	}

	public void setCOUNTRY(String country) {
		COUNTRY = country;
	}
	
	@OneToOne
	@JoinColumn(name = "TRADE_MARK")
	private TradeMark TRADE_MARK;

	public TradeMark getTRADE_MARK() {
		return TRADE_MARK;
	}

	public void setTRADE_MARK(TradeMark trade_mark) {
		TRADE_MARK = trade_mark;
	}
	
}
