package com.mihigo.main.service.hospital;

import java.util.List;

import com.mihigo.main.model.Hospital;

public interface HospitalService {

	Hospital createHospital(String country, String city, String sector, String cell, String phone, String email,String name);

	List<Hospital> allHospital();

}
