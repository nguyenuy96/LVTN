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
@Table(name = "THUONG_HIEU")
public class TradeMark implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int TRADE_MARK_ID;
	
	@Column(name = "THUONG_HIEU", nullable = false, unique = true)
	private String TRADE_MARK;
	
	public TradeMark(int trade_mark_id) {
		this.TRADE_MARK_ID = trade_mark_id;
	}
	
	public TradeMark(int trade_mark_id, String trade_mark) {
		this.TRADE_MARK_ID = trade_mark_id;
		this.TRADE_MARK = trade_mark;
	}

	public int getTRADE_MARK_ID() {
		return TRADE_MARK_ID;
	}

	public void setTRADE_MARK_ID(int trade_mark_id) {
		TRADE_MARK_ID = trade_mark_id;
	}

	public String getTRADE_MARK() {
		return TRADE_MARK;
	}

	public void setTRADE_MARK(String trade_mark) {
		TRADE_MARK = trade_mark;
	}
	
	@OneToOne(mappedBy = "TRADE_MARK")
	private Country COUNTRY;

	public Country getCOUNTRY() {
		return COUNTRY;
	}

	public void setCOUNTRY(Country country) {
		COUNTRY = country;
	}
	
}
