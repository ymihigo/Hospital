package com.mihigo.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mihigo.main.exception.InvalidParameters;
import com.mihigo.main.model.Hospital;
import com.mihigo.main.payload.HospitalPayload;
import com.mihigo.main.service.hospital.HospitalService;

@RestController
@RequestMapping("/hospital")
public class Controller {

	@Autowired
	private HospitalService hoservice;

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
}
