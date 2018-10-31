package com.app.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "KHUYEN_MAI")
public class Promotion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_KHUYEN_MAI", nullable = false, unique = true)
	private int promId;
	
	/******************************************************************************/
	
	@Column(name = "KHUYEN_MAI", nullable = false)
	private String promotion;
	
	/******************************************************************************/
	
	@Column(name = "NGAY_BAT_DAU", nullable = false)
	private Date startDate;
	
	/******************************************************************************/
	
	@Column(name = "NGAY_KET_THUC", nullable = false)
	private Date endDate;
	
	/******************************************************************************/
	
	public Promotion() {}
	
	public Promotion(int promId, String promation, Date startDate, Date endDate) {
		this.promId = promId;
		this.promotion = promation;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/******************************************************************************/
	
	public int getPromId() {
		return promId;
	}

	public void setPromId(int promId) {
		this.promId = promId;
	}

	/******************************************************************************/
	
	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	/******************************************************************************/
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/******************************************************************************/
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/******************************************************************************/
	
	@OneToMany(mappedBy = "promotionId")
	private Set<Product> item;

	public Set<Product> getItem() {
		return item;
	}

	public void setItem(Set<Product> item) {
		this.item = item;
	}
	
}
