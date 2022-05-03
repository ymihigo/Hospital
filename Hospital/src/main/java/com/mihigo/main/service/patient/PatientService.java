package com.mihigo.main.service.patient;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mihigo.main.model.Patient;
import com.mihigo.main.model.PatientFile;

public interface PatientService {

	Patient createPatient(String country, String city, String sector, String cell, String phone, String email,
			String gender, String dob);

	List<Patient> allPatient();

	List<Patient> allPatientByHospital(int hospitalId);

	PatientFile createPatientFile(long patient_id, MultipartFile fle, int hospital_Id);
	
	List<PatientFile> allPatientFile(long patientid);
}
