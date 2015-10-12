package com.icare.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.icare.beans.PrescriptionBean;
import com.icare.daos.MedicineDao;
import com.icare.daos.PrescriptionDao;
import com.icare.entities.MedicineEntity;
import com.icare.entities.PrescriptionEntity;
import com.icare.exceptions.PrescriptionServiceException;
import com.icare.utils.BeanCreatorUtil;
import com.icare.utils.EntityCreatorUtil;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	private PrescriptionDao prescriptionDao;

	@Autowired
	private MedicineDao medicineDao;

	@Override
	public void save(PrescriptionBean bean) throws PrescriptionServiceException {
		validateBean(bean);
		PrescriptionEntity prescription = EntityCreatorUtil
				.createPrescription(bean);
		List<MedicineEntity> medicines = medicineDao.fetchByName(bean
				.getMedicine().getName());
		MedicineEntity medicineEntity = medicines.get(0);
		prescription.setMedicine(medicineEntity);
		prescription.setMedicineId(medicineEntity.getId());
		prescriptionDao.save(prescription);
	}

	public void validateBean(PrescriptionBean bean)
			throws PrescriptionServiceException {
		if (0 == bean.getMedQuantity() || null == bean.getMedicine()
				|| StringUtils.isEmpty(bean.getFreqType())
				|| " ".equalsIgnoreCase(bean.getFreqType())
				|| 0 == bean.getFrequency() || null == bean.getVisit()
				|| 0 == bean.getVisit().getId()) {
			throw new PrescriptionServiceException(
					"Mandatory fields should not be empty");
		}
	}

	@Override
	public void update(PrescriptionBean bean)
			throws PrescriptionServiceException {
		validateBean(bean);
		PrescriptionEntity prescriptionEntity = EntityCreatorUtil
				.createPrescription(bean);
		prescriptionDao.update(prescriptionEntity);
	}

	@Override
	public List<PrescriptionBean> fetchByVisitId(int visitId)
			throws PrescriptionServiceException {
		List<PrescriptionEntity> prescriptions = prescriptionDao
				.fetchByVisitId(visitId);

		if (CollectionUtils.isEmpty(prescriptions)) {
			throw new PrescriptionServiceException("No records found");
		}

		List<PrescriptionBean> beans = new ArrayList<>();

		for (PrescriptionEntity prescription : prescriptions) {
			PrescriptionBean bean = BeanCreatorUtil.prescription(prescription);
			beans.add(bean);
		}

		return beans;
	}

}
