package com.mihigo.main.service.patient;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mihigo.main.model.Gender;
import com.mihigo.main.model.Hospital;
import com.mihigo.main.model.Patient;
import com.mihigo.main.model.PatientFile;
import com.mihigo.main.repositories.HospitalRepo;
import com.mihigo.main.repositories.PatientFileRepo;
import com.mihigo.main.repositories.PatientRepo;

@Service
public class PatientServiceImplemation implements PatientService {

	@Autowired
	private PatientRepo parepo;

	@Autowired
	private PatientFileRepo pfr;

	@Autowired
	private HospitalRepo hr;

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

	@Override
	public PatientFile createPatientFile(long patient_id, MultipartFile fle, int hospital_Id) {
		try {
			String img = StringUtils.cleanPath(fle.getOriginalFilename());

			if (img.contains("..") || img.isBlank()) {
				throw new RuntimeException("Please upload collect image");
			}
			Optional<Patient> pa = parepo.findById(patient_id);

			if (!pa.isPresent()) {
				throw new RuntimeException("Invalid patient id");
			}

			Optional<Hospital> ho = hr.findById(hospital_Id);

			if (ho.isEmpty()) {
				throw new RuntimeException("Invalid Hospital Id");
			}

			String file = Base64.getEncoder().encodeToString(fle.getBytes());

			return pfr.saveAndFlush(new PatientFile(pa.get(), file, ho.get()));

		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

	@Override
	public List<PatientFile> allPatientFile(long patientid) {
		try {
			Optional<Patient> pp = parepo.findById(patientid);
			if (pp.isEmpty()) {
				throw new RuntimeException("Invalid patient");
			}
			return pfr.getPatientFiles(pp.get());
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

}
