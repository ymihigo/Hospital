package com.mihigo.main.service.patient;

import java.util.List;

import com.mihigo.main.model.Patient;

public interface PatientService {

	Patient createPatient(String country, String city, String sector, String cell, String phone, String email,
			String gender, String dob);

	List<Patient> allPatient();

	List<Patient> allPatientByHospital(int hospitalId);
}
