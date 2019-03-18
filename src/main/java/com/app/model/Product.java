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


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SAN_PHAM")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_SAN_PHAM", nullable = false, unique = true)
	private int productId;

	/******************************************************************************/

	@Column(name = "TEN_SAN_PHAM", nullable = false, unique = true)
	private String productName;

	/******************************************************************************/

	@Column(name = "THANH_PHAN", length = 1000)
	private String ingredient;

	/******************************************************************************/

	@Column(name = "NGAY_SAN_XUAT")
	private Date manufDate;

	/******************************************************************************/

	@Column(name = "HAN_SU_DUNG")
	private Date expiryDate;

	/******************************************************************************/

	@OneToOne
	@JoinTable(name = "SAN_PHAM_DOI_TUONG", joinColumns = {
			@JoinColumn(name = "MA_SAN_PHAM", referencedColumnName = "MA_SAN_PHAM") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_DOI_TUONG", referencedColumnName = "MA_DOI_TUONG") })
	private ObjectUser objectUser;

	/******************************************************************************/

	@Column(name = "HUONG_DAN_SU_DUNG", length = 1000)
	private String useGuide;

	/******************************************************************************/

	@Column(name = "KHOI_LUONG_TINH")
	private Float net;

	/******************************************************************************/

	@Column(name = "LUU_Y")
	private String note;

	/******************************************************************************/

	@Column(name = "BAO_HANH", length = 1000)
	private String guarantee;

	/******************************************************************************/

	@Column(name = "DON_GIA")
	private String unitPrice;

	/******************************************************************************/

	@Column(name = "BAO_QUAN", length = 1000)
	private String preservation;

	/******************************************************************************/

	@Column(name = "DAC_DIEM_NOI_BAT", length = 1000)
	private String outstdFeatures;

	/******************************************************************************/

	@Column(name = "MO_TA", length = 1000)
	private String description;

	/******************************************************************************/

	@OneToOne
	@JoinTable(name = "THUONGHIEU_SANPHAM", joinColumns = {
			@JoinColumn(name = "MA_SAN_PHAM", referencedColumnName = "MA_SAN_PHAM") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_THUONG_HIEU", referencedColumnName = "MA_THUONG_HIEU") })
	private TradeMark tradeMark;

	/******************************************************************************/

	@ManyToOne
	@JoinTable(name = "SANPHAM_CANNANG", joinColumns = {
			@JoinColumn(name = "MA_SAN_PHAM", referencedColumnName = "MA_SAN_PHAM") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_CAN_NANG", referencedColumnName = "MA_CAN_NANG") })
	private Weight weight;

	/******************************************************************************/
	@ManyToOne
	@JoinTable(name = "SANPHAM_DOTUOI", joinColumns = {
			@JoinColumn(name = "MA_SAN_PHAM", referencedColumnName = "MA_SAN_PHAM") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_DO_TUOI", referencedColumnName = "MA_DO_TUOI") })
	private Age age;

	/******************************************************************************/

	@ManyToOne
	@JoinTable(name = "SANPHAM_KHUYENMAI", joinColumns = {
			@JoinColumn(name = "MA_SAN_PHAM", referencedColumnName = "MA_SAN_PHAM") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_KHUYEN_MAI", referencedColumnName = "MA_KHUYEN_MAI") })
	private Promotion promotionId;

	/******************************************************************************/

	@ManyToOne
	@JoinTable(name = "SANPHAM_LOAIHANG", joinColumns = {
			@JoinColumn(name = "MA_SAN_PHAM", referencedColumnName = "MA_SAN_PHAM") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_LOAI_HANG", referencedColumnName = "MA_LOAI_HANG") })
	private ProductType productType;

	/******************************************************************************/

	@OneToOne
	@JoinTable(name = "SAN_PHAM_HINH_ANH", joinColumns = {
			@JoinColumn(name = "MA_SAN_PHAM", referencedColumnName = "MA_SAN_PHAM") }, inverseJoinColumns = {
					@JoinColumn(name = "MA_HINH_ANH", referencedColumnName = "MA_HINH_ANH") })
	private ProductImage image;

	public Product() {
	}

	public Product(int productId, String productName, String ingredient, Date manufDate, Date expiryDate,
			ObjectUser objectUser, ProductImage image, String useGuide, Float net, String note, String guarantee,
			String unitPrice, String preservation, String outstdFeatures, String description, TradeMark tradeMark,
			Weight weight, Age age, Promotion promotionId, ProductType productType) {
		this.productId = productId;
		this.productName = productName;
		this.ingredient = ingredient;
		this.manufDate = manufDate;
		this.expiryDate = expiryDate;
		this.objectUser = objectUser;
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public ObjectUser getObjectUser() {
		return objectUser;
	}

	public void setObjectUser(ObjectUser objectUser) {
		this.objectUser = objectUser;
	}

	public ProductImage getImage() {
		return image;
	}

	public void setImage(ProductImage image) {
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
