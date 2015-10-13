package com.icare.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icare.beans.PatientBean;
import com.icare.daos.PatientDao;
import com.icare.entities.PatientEntity;
import com.icare.exceptions.PatientServiceException;

@Service
public class PatientService {

	static final Logger LOGGER = LoggerFactory
			.getLogger(PatientService.class);

	@Autowired
	private PatientDao patientDao;

	public void save(PatientBean patientBean) throws PatientServiceException {
		PatientEntity patientEntity = new PatientEntity();
		patientEntity.setAddress(patientBean.getAddress());
		patientEntity.setAge(patientBean.getAge());
		patientEntity.setContactNo(patientBean.getContactNo());
		patientEntity.setFees(patientBean.getFees());
		patientEntity.setId(patientBean.getId());
		patientEntity.setMrdNo(patientBean.getMrdNo());
		patientEntity.setName(patientBean.getName());
		patientEntity.setProcedureFees(patientBean.getProcedureFees());
		patientEntity.setReferredBy(patientBean.getReferredBy());
		patientEntity.setSex(patientBean.getSex());
		patientDao.save(patientEntity);
		patientBean.setId(patientEntity.getId());
	}

}
