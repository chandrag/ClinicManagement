package com.icare.daos;

import java.util.List;

import com.icare.entities.PrescriptionEntity;

public interface PrescriptionDao {

	void save(PrescriptionEntity prescription);

	void update(PrescriptionEntity prescription);

	List<PrescriptionEntity> fetchByVisitId(int visitId);

}
