package com.icare.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.icare.beans.PrescriptionBean;
import com.icare.beans.VisitBean;
import com.icare.daos.PrescriptionDao;
import com.icare.daos.VisitDao;
import com.icare.entities.PrescriptionEntity;
import com.icare.entities.VisitEntity;
import com.icare.exceptions.VisitException;
import com.icare.utils.EntityCreatorUtil;

@Service
public class VisitService {

	@Autowired
	private VisitDao visitDao;

	@Autowired
	private PrescriptionDao prescriptionDao;

	public void save(VisitBean visitBean) throws VisitException {
		if (visitBean.getPatient() == null
				|| StringUtils.isEmpty(visitBean.getProblems())
				|| CollectionUtils.isEmpty(visitBean.getPrescriptions())) {
			throw new VisitException("Mandatory fields should not be null");
		}

		for (PrescriptionBean prescriptionBean : visitBean.getPrescriptions()) {
			PrescriptionEntity prescriptionEntity = EntityCreatorUtil
					.createPrescription(prescriptionBean);
			prescriptionDao.save(prescriptionEntity);
		}

	}

	public List<VisitBean> fetchByPatientId(int patientId)
			throws VisitException {
		List<VisitEntity> visits = visitDao.fetchByPatientId(patientId);
		if (CollectionUtils.isEmpty(visits)) {
			throw new VisitException("No Visits Found for this patient");
		}
		List<VisitBean> beans = new ArrayList<>();
		return beans;
	}

	public void update(VisitBean visitBean) throws VisitException {
		if (StringUtils.isEmpty(visitBean.getProblems())
				|| StringUtils.isEmpty(visitBean.getTestResults())) {
			throw new VisitException("The mandatory fields cannot be null");
		}

	}

}
