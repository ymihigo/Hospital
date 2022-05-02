package com.mihigo.main.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class PatientFile implements Serializable {
	/**
	 * 
	 */
	private static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Patient patient_id;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	@ManyToOne
	private Hospital registeredBy;

	public PatientFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientFile(long id, Patient patient_id, String image, Hospital registeredBy) {
		this.id = id;
		this.patient_id = patient_id;
		this.image = image;
		this.registeredBy = registeredBy;
	}

	public PatientFile(Patient patient_id, String image, Hospital registeredBy) {
		this.patient_id = patient_id;
		this.image = image;
		this.registeredBy = registeredBy;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		PatientFile.serialVersionUID = serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Patient getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Patient patient_id) {
		this.patient_id = patient_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Hospital getRegisteredBy() {
		return registeredBy;
	}

	public void setRegisteredBy(Hospital registeredBy) {
		this.registeredBy = registeredBy;
	}

}
