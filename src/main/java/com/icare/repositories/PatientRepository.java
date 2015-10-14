package com.icare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icare.entities.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {

	List<PatientEntity> findByNameContaining(String name);

}
