package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
}
