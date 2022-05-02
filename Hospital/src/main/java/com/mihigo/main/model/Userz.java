package com.mihigo.main.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Userz extends Address implements Serializable {

	/**
	 * 
	 */
	private static long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private String names;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRole role;
	@ManyToOne
	private Hospital hospital;

	public Userz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Userz(String country, String city, String sector, String cell, String phone, String email) {
		super(country, city, sector, cell, phone, email);
		// TODO Auto-generated constructor stub
	}

	public Userz(String country, String city, String sector, String cell, String phone, String email, int id,
			String names, String username, String password, UserRole role, Hospital hospital) {
		super(country, city, sector, cell, phone, email);
		this.id = id;
		this.names = names;
		this.username = username;
		this.password = password;
		this.role = role;
		this.hospital = hospital;
	}

	public Userz(String country, String city, String sector, String cell, String phone, String email, String names,
			String username, String password, UserRole role, Hospital hospital) {
		super(country, city, sector, cell, phone, email);
		this.names = names;
		this.username = username;
		this.password = password;
		this.role = role;
		this.hospital = hospital;
	}

	public Userz(String country, String city, String sector, String cell, String phone, String email, String names,
			String username, String password, UserRole role) {
		super(country, city, sector, cell, phone, email);
		this.names = names;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		Userz.serialVersionUID = serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

}
