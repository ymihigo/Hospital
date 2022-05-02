package com.mihigo.main.payload;

import org.springframework.stereotype.Component;

@Component
public class HospitalPayload {
	private String country;
	private String city;
	private String sector;
	private String cell;
	private String phone;
	private String email;
	private String name;

	public HospitalPayload() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HospitalPayload(String country, String city, String sector, String cell, String phone, String email,
			String name) {
		this.country = country;
		this.city = city;
		this.sector = sector;
		this.cell = cell;
		this.phone = phone;
		this.email = email;
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
