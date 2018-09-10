package com.app.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "SAN_PHAM")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int itemId;

	/******************************************************************************/

	@Column(name = "TEN_SAN_PHAM", nullable = false, unique = true)
	private String itemName;

	/******************************************************************************/

	@Column(name = "THANH_PHAN", nullable = false)
	private String ingredient;

	/******************************************************************************/

	@Column(name = "NGAY_SAN_XUAT")
	private Date manufDate;

	/******************************************************************************/

	@Column(name = "HAN_SU_DUNG")
	private Date expiryDate;

	/******************************************************************************/

	@Column(name = "DOI_TUONG")
	private String useObject;

	/******************************************************************************/

	@Column(name = "HINH_ANH")
	private String image;

	/******************************************************************************/

	@Column(name = "HUONG_DAN_SU_DUNG")
	private String useGuide;

	/******************************************************************************/

	@Column(name = "KHOI_LUONG")
	private float net;

	/******************************************************************************/

	@Column(name = "LUU_Y")
	private String note;

	/******************************************************************************/

	@Column(name = "BAO_HANH")
	private String guarantee;

	/******************************************************************************/

	@Column(name = "DON_GIA")
	private double unitPrice;

	/******************************************************************************/

	@Column(name = "SO_LUONG")
	private int amount;

	/******************************************************************************/

	@Column(name = "BAO_QUAN")
	private String preservation;

	/******************************************************************************/

	@Column(name = "DAC_DIEM_NOI_BAT")
	private String outstdFeatures;

	/******************************************************************************/

	@Column(name = "MO_TA")
	private String description;

	/******************************************************************************/

	public Item(int itemId) {
		this.itemId = itemId;
	}

	public Item(int itemId, String itemName, String ingredient, Date manufDate, Date expiryDate, String useObject,
			String image, String useGuide, float net, String note, String guarantee, double unitPrice, int amount,
			String preservation, String outstdFeatures, String description) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.ingredient = ingredient;
		this.manufDate = manufDate;
		this.expiryDate = expiryDate;
		this.useObject = useObject;
		this.image = image;
		this.useGuide = useGuide;
		this.net = net;
		this.note = note;
		this.guarantee = guarantee;
		this.unitPrice = unitPrice;
		this.amount = amount;
		this.preservation = preservation;
		this.outstdFeatures = outstdFeatures;
		this.description = description;
	}

	/******************************************************************************/

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/******************************************************************************/

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/******************************************************************************/

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	/******************************************************************************/

	public Date getManufDate() {
		return manufDate;
	}

	public void setManufDate(Date manufDate) {
		this.manufDate = manufDate;
	}

	/******************************************************************************/

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/******************************************************************************/

	public String getUseObject() {
		return useObject;
	}

	public void setUseObject(String useObject) {
		this.useObject = useObject;
	}

	/******************************************************************************/

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	/******************************************************************************/

	public String getUseGuide() {
		return useGuide;
	}

	public void setUseGuide(String useGuide) {
		this.useGuide = useGuide;
	}

	/******************************************************************************/

	public float getNet() {
		return net;
	}

	public void setNet(float net) {
		this.net = net;
	}

	/******************************************************************************/

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	/******************************************************************************/

	public String getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(String guarantee) {
		this.guarantee = guarantee;
	}

	/******************************************************************************/

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/******************************************************************************/

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	/******************************************************************************/

	public String getPreservation() {
		return preservation;
	}

	public void setPreservation(String preservation) {
		this.preservation = preservation;
	}

	/******************************************************************************/

	public String getOutstdFeatures() {
		return outstdFeatures;
	}

	public void setOutstdFeatures(String outstdFeatures) {
		this.outstdFeatures = outstdFeatures;
	}

	/******************************************************************************/

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/******************************************************************************/

	@OneToOne
	@JoinColumn(name = "THUONG_HIEU")
	private TradeMark tradeMark;

	public TradeMark getTradeMark() {
		return tradeMark;
	}

	public void setTradeMark(TradeMark tradeMark) {
		this.tradeMark = tradeMark;
	}

	/******************************************************************************/

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "CAN_NANG")
	private Weight weight;

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	/******************************************************************************/
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "DO_TUOI")
	private Age age;

	public Age getAge() {
		return age;
	}

	public void setAge(Age age) {
		this.age = age;
	}

	/******************************************************************************/

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "KHUYEN_MAI")
	private Promotion promotion;

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	/******************************************************************************/

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "LOAI_HANG")
	private ItemType itemType;

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	/******************************************************************************/

}
