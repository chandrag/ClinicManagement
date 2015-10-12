package com.icare.daos;

import com.icare.entities.PatientEntity;
import com.icare.exceptions.NoDataFoundException;

public interface PatientDao {

	void save(PatientEntity patient);

	void update(PatientEntity patient) throws NoDataFoundException;

	PatientEntity search(int id) throws NoDataFoundException;

	PatientEntity searchByName(String firstName, String lastName)
			throws NoDataFoundException;

	void delete(PatientEntity patient);

}
