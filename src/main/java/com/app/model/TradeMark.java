package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trademark")
public class TradeMark {

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

	public TradeMark(Long tradeMarkId) {
		this.tradeMarkId = tradeMarkId;
	}
}
