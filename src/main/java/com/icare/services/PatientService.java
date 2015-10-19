package com.icare.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.icare.beans.PatientBean;
import com.icare.entities.PatientEntity;
import com.icare.exceptions.NoDataFoundException;
import com.icare.exceptions.PatientServiceException;
import com.icare.repositories.PatientRepository;
import com.icare.utils.BeanCreatorUtil;
import com.icare.utils.EntityCreatorUtil;

@Service
public class PatientService {

	static final Logger LOGGER = LoggerFactory.getLogger(PatientService.class);

	@Autowired
	private PatientRepository patientRepository;

	public void save(PatientBean patientBean) throws PatientServiceException {
		PatientEntity patientEntity = EntityCreatorUtil
				.createPatientEntity(patientBean);
		patientRepository.save(patientEntity);
		patientBean.setId(patientEntity.getId());
	}

	public List<PatientBean> searchPatient(String name)
			throws NoDataFoundException {
		List<PatientEntity> searchedPatients = patientRepository
				.findByNameContaining(name);
		List<PatientBean> patients = new ArrayList<PatientBean>();
		if (CollectionUtils.isEmpty(searchedPatients)) {
			throw new NoDataFoundException("No patients found");
		}
		for (PatientEntity entity : searchedPatients) {
			PatientBean bean = BeanCreatorUtil.createPatientBean(entity);
			patients.add(bean);
		}
		return patients;
	}

	public PatientBean findById(Integer id) {
		PatientEntity entity = patientRepository.findOne(id);
		return BeanCreatorUtil.createPatientBean(entity);
	}

	public Integer delete(Integer patientId) {
		patientRepository.delete(patientId);
		return patientId;
	}
}
