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
@Table(name = "trademark")
public class TradeMark implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tradeMarkId;

	@Column(nullable = false, unique = true)
	private String tradeMark;

	@OneToOne
	@JoinTable(name = "country_of_trademark", joinColumns = {
			@JoinColumn(name = "tradeMarkId", referencedColumnName = "tradeMarkId") }, inverseJoinColumns = {
					@JoinColumn(name = "countryId", referencedColumnName = "countryId") })
	private Country country;

	public TradeMark() {}

	public TradeMark(Long tradeMarkId) {
		this.tradeMarkId = tradeMarkId;
	}
	public TradeMark(Long tradeMarkId, String tradeMark, Country country) {
		this.tradeMarkId = tradeMarkId;
		this.tradeMark = tradeMark;
		this.country = country;
	}

	public Long getTradeMarkId() {
		return tradeMarkId;
	}

	public void setTradeMarkId(Long tradeMarkId) {
		this.tradeMarkId = tradeMarkId;
	}

	public String getTradeMark() {
		return tradeMark;
	}

	public void setTradeMark(String tradeMark) {
		this.tradeMark = tradeMark;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
