package com.app.model;

import java.io.Serializable;
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
@Table(name = "LOAI_HANG")
public class ItemType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int itemTypeId;
	
	/******************************************************************************/
	
	@Column(name = "LOAI_HANG", nullable = false, unique = true)
	private String itemType;
	
	/******************************************************************************/
	
	public ItemType() {	}
	
	public ItemType(int itemTypeId, String itemType) {
		this.itemTypeId = itemTypeId;
		this.itemType = itemType;
	}

	/******************************************************************************/
	
	public int getItemTypeId() {
		return itemTypeId;
	}

	public void setItemTypeId(int itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	/******************************************************************************/
	
	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	/******************************************************************************/
	
	@JsonManagedReference
	@OneToMany(mappedBy = "itemTypeId")
	private Set<Item> item;

	public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}
	
}
