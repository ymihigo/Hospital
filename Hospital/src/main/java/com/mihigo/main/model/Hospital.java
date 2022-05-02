package com.mihigo.main.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Hospital extends Address implements Serializable {
	/**
	 * 
	 */
	private static long serialVersionUID = -8842532911207852217L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true)
	private String name;

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(String country, String city, String sector, String cell, String phone, String email) {
		super(country, city, sector, cell, phone, email);
		// TODO Auto-generated constructor stub
	}

	public Hospital(String country, String city, String sector, String cell, String phone, String email, int id,
			String name) {
		super(country, city, sector, cell, phone, email);
		this.id = id;
		this.name = name;
	}

	public Hospital(String country, String city, String sector, String cell, String phone, String email, String name) {
		super(country, city, sector, cell, phone, email);
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

}
