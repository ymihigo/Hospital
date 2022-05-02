package com.mihigo.main.service.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mihigo.main.model.Hospital;
import com.mihigo.main.repositories.HospitalRepo;

public class HospitalServiceImplementation implements HospitalService {

	@Autowired
	private HospitalRepo hospirepo;

	@Override
	public Hospital createHospital(String country, String city, String sector, String cell, String phone, String email,
			String name) {
		try {
			if (country.isEmpty() || city.isEmpty() || sector.isEmpty() || cell.isEmpty() || phone.isEmpty()
					|| email.isEmpty() || name.isEmpty()) {

				throw new RuntimeException("Please fill requirements");
			}
			return hospirepo.saveAndFlush(new Hospital(country, city, sector, cell, phone, email, name));
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

	@Override
	public List<Hospital> allHospital() {
		try {
			return hospirepo.findAll();
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

}
