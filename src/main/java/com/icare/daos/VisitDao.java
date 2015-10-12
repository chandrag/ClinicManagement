package com.icare.daos;

import java.util.List;

import com.icare.entities.VisitEntity;

public interface VisitDao {

	void save(VisitEntity visitEntity);

	List<VisitEntity> fetchByPatientId(int patientId);

	void update(VisitEntity visitEntity);

	VisitEntity findById(int visitId);

}
