package com.mihigo.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mihigo.main.model.Hospital;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital, Integer> {

}
