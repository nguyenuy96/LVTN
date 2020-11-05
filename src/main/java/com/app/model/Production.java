package com.app.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "production")
public class Production implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productionId;

	@Column(nullable = false, unique = true)
	@NotBlank
	private String productionName;

	@Column(length = 1000)
	private String ingredient;

	private Date manufDate;

	private Date expiryDate;

	@OneToOne
	@JoinTable(name = "production_of_use", joinColumns = {
			@JoinColumn(name = "productionId", referencedColumnName = "productionId") }, inverseJoinColumns = {
					@JoinColumn(name = "productionUserId", referencedColumnName = "productionUserId") })
	private ProductionUser productionUser;

	@Column(length = 1000)
	private String useGuide;

	private Float net;

	private String note;

	@Column(length = 1000)
	private String guarantee;

	private String unitPrice;

	@Column(length = 1000)
	private String preservation;

	@Column(length = 1000)
	private String outstdFeatures;

	@Column(length = 1000)
	private String description;

	@OneToOne
	@JoinColumn(name = "trade_mark_id")
	private TradeMark tradeMark;

	@ManyToOne
	@JoinColumn(name = "weight_of_usage_id")
	private WeightOfUsage weightOfUsage;

	@ManyToOne
	@JoinColumn(name = "age_of_usage_if")
	private AgeOfUsage ageOfUsage;

	@ManyToOne
	@JoinColumn(name = "promotion_id")
	private Promotion promotion;

	@ManyToOne
	@JoinColumn(name = "production_type_id")
	private ProductionType productionType;

	@OneToOne
	@JoinColumn(name = "image_id")
	private ProductionImage image;

	public Production(Long productionId) {
		this.productionId = productionId;
	}

	public Production(Long productionId, String productionName, String ingredient, Date manufDate, Date expiryDate,
					  ProductionUser productionUser, ProductionImage image, String useGuide, Float net, String note, String guarantee,
					  String unitPrice, String preservation, String outstdFeatures, String description, TradeMark tradeMark,
					  WeightOfUsage weightOfUsage, AgeOfUsage ageOfUsage, Promotion promotion, ProductionType productionType) {
		this.productionId = productionId;
		this.productionName = productionName;
		this.ingredient = ingredient;
		this.manufDate = manufDate;
		this.expiryDate = expiryDate;
		this.productionUser = productionUser;
		this.image = image;
		this.useGuide = useGuide;
		this.net = net;
		this.note = note;
		this.guarantee = guarantee;
		this.unitPrice = unitPrice;
		this.preservation = preservation;
		this.outstdFeatures = outstdFeatures;
		this.description = description;
		this.tradeMark = tradeMark;
		this.weightOfUsage = weightOfUsage;
		this.ageOfUsage = ageOfUsage;
		this.promotion = promotion;
		this.productionType = productionType;
	}

	@OneToMany(mappedBy = "cartDetailId.production", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<CartDetail> productCart = new HashSet<CartDetail>();

	@OneToMany(mappedBy = "exportRecDetailId.production", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<ExportRecDetail> exportRecDetail = new HashSet<ExportRecDetail>();
}
