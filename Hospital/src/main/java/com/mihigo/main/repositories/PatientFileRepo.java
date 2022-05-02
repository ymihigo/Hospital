package com.mihigo.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mihigo.main.model.PatientFile;

@Repository
public interface PatientFileRepo extends JpaRepository<PatientFile, Long>{

}
