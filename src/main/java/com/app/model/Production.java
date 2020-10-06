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
	@JoinTable(name = "trademark_production", joinColumns = {
			@JoinColumn(name = "productionId", referencedColumnName = "productionId") }, inverseJoinColumns = {
					@JoinColumn(name = "tradeMarkId", referencedColumnName = "tradeMarkId") })
	private TradeMark tradeMark;

	/******************************************************************************/

	@ManyToOne
	@JoinTable(name = "production_weight", joinColumns = {
			@JoinColumn(name = "productionId", referencedColumnName = "productionId") }, inverseJoinColumns = {
					@JoinColumn(name = "weightId", referencedColumnName = "weightId") })
	private Weight weight;

	@ManyToOne
	@JoinTable(name = "production_age", joinColumns = {
			@JoinColumn(name = "productionId", referencedColumnName = "productionId") }, inverseJoinColumns = {
					@JoinColumn(name = "ageId", referencedColumnName = "ageId") })
	private Age age;

	@ManyToOne
	@JoinTable(name = "production_promotion", joinColumns = {
			@JoinColumn(name = "productionId", referencedColumnName = "productionId") }, inverseJoinColumns = {
					@JoinColumn(name = "promotionId", referencedColumnName = "promotionId") })
	private Promotion promotionId;

	@ManyToOne
	@JoinTable(name = "type_of_production", joinColumns = {
			@JoinColumn(name = "productionId", referencedColumnName = "productionId") }, inverseJoinColumns = {
					@JoinColumn(name = "productionTypeId", referencedColumnName = "productionTypeId") })
	private ProductType productType;

	@OneToOne
	@JoinTable(name = "image_of_production", joinColumns = {
			@JoinColumn(name = "productionId", referencedColumnName = "productionId") }, inverseJoinColumns = {
					@JoinColumn(name = "imageId", referencedColumnName = "imageId") })
	private ProductionImage image;

	public Production() {
	}

	public Production(Long productionId) {
		this.productionId = productionId;
	}

	public Production(Long productionId, String productionName, String ingredient, Date manufDate, Date expiryDate,
					  ProductionUser productionUser, ProductionImage image, String useGuide, Float net, String note, String guarantee,
					  String unitPrice, String preservation, String outstdFeatures, String description, TradeMark tradeMark,
					  Weight weight, Age age, Promotion promotionId, ProductType productType) {
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
		this.weight = weight;
		this.age = age;
		this.promotionId = promotionId;
		this.productType = productType;
	}

	public Long getProductionId() {
		return productionId;
	}

	public void setProductionId(Long productionId) {
		this.productionId = productionId;
	}

	public String getProductionName() {
		return productionName;
	}

	public void setProductionName(String productionName) {
		this.productionName = productionName;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public Date getManufDate() {
		return manufDate;
	}

	public void setManufDate(Date manufDate) {
		this.manufDate = manufDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public ProductionUser getProductionUser() {
		return productionUser;
	}

	public void setProductionUser(ProductionUser productionUser) {
		this.productionUser = productionUser;
	}

	public ProductionImage getImage() {
		return image;
	}

	public void setImage(ProductionImage image) {
		this.image = image;
	}

	public String getUseGuide() {
		return useGuide;
	}

	public void setUseGuide(String useGuide) {
		this.useGuide = useGuide;
	}

	public Float getNet() {
		return net;
	}

	public void setNet(Float net) {
		this.net = net;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(String guarantee) {
		this.guarantee = guarantee;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getPreservation() {
		return preservation;
	}

	public void setPreservation(String preservation) {
		this.preservation = preservation;
	}

	public String getOutstdFeatures() {
		return outstdFeatures;
	}

	public void setOutstdFeatures(String outstdFeatures) {
		this.outstdFeatures = outstdFeatures;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TradeMark getTradeMark() {
		return tradeMark;
	}

	public void setTradeMark(TradeMark tradeMark) {
		this.tradeMark = tradeMark;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	public Age getAge() {
		return age;
	}

	public void setAge(Age age) {
		this.age = age;
	}

	public Promotion getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Promotion promotionId) {
		this.promotionId = promotionId;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	@OneToMany(mappedBy = "cartDetailId.product", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<CartDetail> productCart = new HashSet<CartDetail>();

	public Set<CartDetail> getProductCart() {
		return productCart;
	}

	public void setProductCart(Set<CartDetail> productCart) {
		this.productCart = productCart;
	}

	@OneToMany(mappedBy = "exportRecDetailId.product", fetch = FetchType.LAZY)
	@JsonIgnore
	
	private Set<ExportRecDetail> exportRecDetail = new HashSet<ExportRecDetail>();

	public Set<ExportRecDetail> getExportRecDetail() {
		return exportRecDetail;
	}

	public void setExportRecDetail(Set<ExportRecDetail> exportRecDetail) {
		this.exportRecDetail = exportRecDetail;
	}
}
