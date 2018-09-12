package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "THUONG_HIEU")
public class TradeMark implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_THUONG_HIEU", nullable = false, unique = true)
	private int tradeMarkId;

	/******************************************************************************/

	@Column(name = "THUONG_HIEU", nullable = false, unique = true)
	private String tradeMark;

	/******************************************************************************/

	@OneToOne
	@JoinTable(name = "THUONGHIEU_XUATXU", joinColumns = {
			@JoinColumn(name = "MA_THUONG_HIEU", referencedColumnName = "MA_THUONG_HIEU") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_QUOC_GIA", referencedColumnName = "MA_QUOC_GIA", unique = true) })
	private Country countryId;

	/******************************************************************************/

	public TradeMark() {}

	public TradeMark(int tradeMarkId, String tradeMark, Country countryId) {
		this.tradeMarkId = tradeMarkId;
		this.tradeMark = tradeMark;
		this.countryId = countryId;
	}

	/******************************************************************************/

	public int getTradeMarkId() {
		return tradeMarkId;
	}

	public void setTradeMarkId(int tradeMarkId) {
		this.tradeMarkId = tradeMarkId;
	}

	/******************************************************************************/

	public String getTradeMark() {
		return tradeMark;
	}

	public void setTradeMark(String tradeMark) {
		this.tradeMark = tradeMark;
	}

	/******************************************************************************/

	public Country getCountry() {
		return countryId;
	}

	public void setCountry(Country countryId) {
		this.countryId = countryId;
	}

	/******************************************************************************/

	@OneToOne(mappedBy = "tradeMarkId")
	private Item item;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
