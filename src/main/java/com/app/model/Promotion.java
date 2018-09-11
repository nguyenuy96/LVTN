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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "KHUYEN_MAI")
public class Promotion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
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
	
	public Promotion(int promId) {
		this.promId = promId;
	}
	
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
	
	@JsonManagedReference
	@OneToMany(mappedBy = "promotionId")
	private Set<Item> item;

	public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}
	
}
