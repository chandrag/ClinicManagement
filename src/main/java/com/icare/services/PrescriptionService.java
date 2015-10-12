package com.icare.services;

import java.util.List;

import com.icare.beans.PrescriptionBean;
import com.icare.exceptions.PrescriptionServiceException;

public interface PrescriptionService {

	void save(PrescriptionBean prescription) throws PrescriptionServiceException;

	void update(PrescriptionBean prescription)
			throws PrescriptionServiceException;

	List<PrescriptionBean> fetchByVisitId(int visitId)
			throws PrescriptionServiceException;
}
