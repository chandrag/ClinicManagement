package com.icare.services;

import com.icare.beans.PatientBean;
import com.icare.exceptions.NoDataFoundException;
import com.icare.exceptions.PatientServiceException;

public interface PatientService {
	void save(PatientBean patientTO) throws PatientServiceException;

	void update(PatientBean patientTO) throws NoDataFoundException;

	PatientBean search(int id) throws NoDataFoundException;

	PatientBean searchByName(String firstName, String lastName)
			throws NoDataFoundException;

	void delete(int patientId) throws NoDataFoundException;
}
