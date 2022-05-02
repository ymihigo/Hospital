package com.mihigo.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mihigo.main.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
