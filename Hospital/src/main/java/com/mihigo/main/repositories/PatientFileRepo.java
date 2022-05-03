package com.mihigo.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mihigo.main.model.Patient;
import com.mihigo.main.model.PatientFile;

@Repository
public interface PatientFileRepo extends JpaRepository<PatientFile, Long>{
	@Query("From PatientFile where patient_id = :pat")
	List<PatientFile> getPatientFiles(@Param("pat") Patient pat);
}
