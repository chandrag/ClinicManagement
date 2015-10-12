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
import com.icare.utils.BeanCreatorUtil;
import com.icare.utils.EntityCreatorUtil;

@Service
public class VisitServiceImpl implements VisitService {

	@Autowired
	private VisitDao visitDao;

	@Autowired
	private PrescriptionDao prescriptionDao;

	@Override
	public void save(VisitBean visitBean) throws VisitException {
		if (visitBean.getPatient() == null
				|| StringUtils.isEmpty(visitBean.getProblems())
				|| CollectionUtils.isEmpty(visitBean.getPrescriptions())) {
			throw new VisitException("Mandatory fields should not be null");
		}
		VisitEntity visitEntity = EntityCreatorUtil.createVisit(visitBean);
		visitDao.save(visitEntity);

		for (PrescriptionBean prescriptionBean : visitBean.getPrescriptions()) {
			PrescriptionEntity prescriptionEntity = EntityCreatorUtil
					.createPrescription(prescriptionBean);
			prescriptionDao.save(prescriptionEntity);
		}

	}

	@Override
	public List<VisitBean> fetchByPatientId(int patientId)
			throws VisitException {
		List<VisitEntity> visits = visitDao.fetchByPatientId(patientId);
		if (CollectionUtils.isEmpty(visits)) {
			throw new VisitException("No Visits Found for this patient");
		}
		List<VisitBean> beans = new ArrayList<>();
		for (VisitEntity visitEntity : visits) {
			VisitBean bean = BeanCreatorUtil.visit(visitEntity);
			List<PrescriptionEntity> prescriptions = prescriptionDao
					.fetchByVisitId(visitEntity.getId());
			for (PrescriptionEntity prescriptionEntity : prescriptions) {
				PrescriptionBean prescriptionBean = BeanCreatorUtil
						.prescription(prescriptionEntity);
				bean.getPrescriptions().add(prescriptionBean);
			}
			beans.add(bean);
		}
		return beans;
	}

	private List<PrescriptionBean> fetchPrescriptions(Integer visitId) {
		List<PrescriptionBean> prescriptionBeans = new ArrayList<>();
		List<PrescriptionEntity> prescriptions = prescriptionDao
				.fetchByVisitId(visitId);
		for (PrescriptionEntity prescriptionEntity : prescriptions) {
			PrescriptionBean prescriptionBean = BeanCreatorUtil
					.prescription(prescriptionEntity);
			prescriptionBeans.add(prescriptionBean);
		}
		return prescriptionBeans;
	}

	@Override
	public void update(VisitBean visitBean) throws VisitException {
		if (StringUtils.isEmpty(visitBean.getProblems())
				|| StringUtils.isEmpty(visitBean.getTestResults())) {
			throw new VisitException("The mandatory fields cannot be null");
		}

		VisitEntity visitEntity = EntityCreatorUtil.createVisit(visitBean);
		visitEntity.setId(visitBean.getId());
		visitDao.update(visitEntity);
	}

	@Override
	public VisitBean findById(int visitId) {
		VisitEntity visitEntity = visitDao.findById(visitId);
		VisitBean visitBean = null;
		if (visitEntity != null) {
			visitBean = BeanCreatorUtil.visit(visitEntity);
			List<PrescriptionBean> prescriptions = fetchPrescriptions(visitEntity
					.getId());
			visitBean.setPrescriptions(prescriptions);
		}
		return visitBean;
	}

}
