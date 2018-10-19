package com.app.model;

public class CusProfDTO {

	private String name;
	private String address;
	private String phoneNumber;

	public String getFullname() {
		return name;
	}

	public void setFullname(String fullname) {
		this.name = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phoneNumber;
	}

	public void setPhone(String phone) {
		this.phoneNumber = phone;
	}
}
