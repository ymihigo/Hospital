package com.mihigo.main.service.patient;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import com.mihigo.main.model.Gender;
import com.mihigo.main.model.Patient;
import com.mihigo.main.repositories.PatientRepo;

@Service
public class PatientServiceImplemation implements PatientService {

	@Autowired
	private PatientRepo parepo;

	DateFormatter format = new DateFormatter("yyyy-MM-dd");

	@Override
	public Patient createPatient(String country, String city, String sector, String cell, String phone, String email,
			String gender, String dob) {

		try {
			if (country.isEmpty() || city.isEmpty() || sector.isEmpty() || cell.isEmpty() || phone.isEmpty()
					|| email.isEmpty() || gender.isEmpty() || dob.isEmpty()) {
				throw new RuntimeException("Please fill all requirement");
			}

			Gender gend = Gender.valueOf(gender);
			Date dateofbirth = format.parse(dob, Locale.ENGLISH);

			return parepo.saveAndFlush(new Patient(country, city, sector, cell, phone, email, gend, dateofbirth));

		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

	@Override
	public List<Patient> allPatient() {
		try {
			return parepo.findAll();
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

	@Override
	public List<Patient> allPatientByHospital(int hospitalId) {
		// TODO Auto-generated method stub
		return null;
	}

}
