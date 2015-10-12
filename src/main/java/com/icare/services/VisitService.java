package com.icare.services;

import java.util.List;

import com.icare.beans.VisitBean;
import com.icare.exceptions.VisitException;

public interface VisitService {
	void save(VisitBean visitBean) throws VisitException;

	List<VisitBean> fetchByPatientId(int patientId) throws VisitException;

	void update(VisitBean visitBean) throws VisitException;

	VisitBean findById(int visitId);

}
