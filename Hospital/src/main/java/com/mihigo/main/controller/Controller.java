package com.mihigo.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mihigo.main.exception.InvalidParameters;
import com.mihigo.main.model.Hospital;
import com.mihigo.main.model.Patient;
import com.mihigo.main.model.PatientFile;
import com.mihigo.main.payload.HospitalPayload;
import com.mihigo.main.payload.PatientPayload;
import com.mihigo.main.service.hospital.HospitalService;
import com.mihigo.main.service.patient.PatientService;

@RestController
@RequestMapping("/hospital")
public class Controller {

	@Autowired
	private HospitalService hoservice;

	@Autowired
	private PatientService ps;

	@RequestMapping(path = "/newhospital", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> createHospital(@RequestBody HospitalPayload hos) throws InvalidParameters {
		try {
			Hospital h = hoservice.createHospital(hos.getCountry(), hos.getCity(), hos.getSector(), hos.getCell(),
					hos.getPhone(), hos.getEmail(), hos.getName());
			return new ResponseEntity<Hospital>(h, HttpStatus.OK);
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}

	@GetMapping("/allHospitals")
	@CrossOrigin(origins = "*")
	public List<Hospital> allHospital() throws InvalidParameters {
		try {
			return hoservice.allHospital();
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}

	@PostMapping("createPatient")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> createPatient(@RequestBody PatientPayload pat) throws InvalidParameters {
		try {
			Patient p = ps.createPatient(pat.getCountry(), pat.getCity(), pat.getSector(), pat.getCell(),
					pat.getPhone(), pat.getEmail(), pat.getGender(), pat.getDob());
			return new ResponseEntity<Patient>(p, HttpStatus.OK);
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}

	@GetMapping("/allpatient")
	@CrossOrigin(origins = "*")
	public List<Patient> allPatient() throws InvalidParameters {
		try {
			return ps.allPatient();
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}

	@PostMapping("/patientfile")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> createPatientFile(@RequestParam("patient") long patient_id,
			@RequestParam("image") MultipartFile image, @RequestParam("hospital") int hospital_id)
			throws InvalidParameters {
		try {
			ps.createPatientFile(patient_id, image, hospital_id);
			return new ResponseEntity<String>("Patient File Saved", HttpStatus.OK);
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}

	@GetMapping("/patient_files")
	@CrossOrigin(origins = "*")
	public List<PatientFile> patientFiles(@RequestParam("patient_id") long pid) throws InvalidParameters {
		try {
			return ps.allPatientFile(pid);
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}

}
