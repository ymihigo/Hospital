package com.mihigo.main.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Patient extends Address implements Serializable {

	private static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Temporal(TemporalType.DATE)
	private Date dob;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String country, String city, String sector, String cell, String phone, String email) {
		super(country, city, sector, cell, phone, email);
		// TODO Auto-generated constructor stub
	}

	public Patient(String country, String city, String sector, String cell, String phone, String email, Long id,
			Gender gender, Date dob) {
		super(country, city, sector, cell, phone, email);
		this.id = id;
		this.gender = gender;
		this.dob = dob;
	}

	public Patient(String country, String city, String sector, String cell, String phone, String email, Gender gender,
			Date dob) {
		super(country, city, sector, cell, phone, email);
		this.gender = gender;
		this.dob = dob;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
