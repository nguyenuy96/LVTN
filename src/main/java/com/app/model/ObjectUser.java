package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DOI_TUONG_SU_DUNG")
public class ObjectUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_DOI_TUONG")
	private Integer objectUserId;
	
	@Column(name = "DOI_TUONG_SU_DUNG")
	private String objectUser;
	
	public ObjectUser() {
		
	}
	
	public ObjectUser(int objectUserId, String objectUser) {
		this.objectUserId = objectUserId;
		this.objectUser = objectUser;
	}
	
	public Integer getObjectUserId() {
		return objectUserId;
	}
	
	public void setObjectUserId(int objectUserId) {
		this.objectUserId = objectUserId;
	}
	
	public String getObjectUser() {
		return objectUser;
	}
	
	public void setObjectUser(String objectUser) {
		this.objectUser = objectUser;
	}
}
