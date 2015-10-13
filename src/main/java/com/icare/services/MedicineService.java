package com.icare.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.icare.beans.MedicineBean;
import com.icare.daos.MedicineDao;
import com.icare.entities.MedicineEntity;
import com.icare.exceptions.MedicineServiceException;
import com.icare.utils.BeanCreatorUtil;
import com.icare.utils.EntityCreatorUtil;

@Service
public class MedicineService {

	@Autowired
	private MedicineDao medicineDao;

	public void save(MedicineBean bean) throws MedicineServiceException {
		if (StringUtils.isEmpty(bean.getName())
				|| StringUtils.isEmpty(bean.getType())
				|| StringUtils.isEmpty(bean.getUnit())) {
			throw new MedicineServiceException(
					"Mandatory fields should not be null");
		}
		MedicineEntity entity = EntityCreatorUtil.createMedicine(bean);
		medicineDao.save(entity);
		bean.setId(entity.getId());
	}

	public List<MedicineBean> fetchByName(String text)
			throws MedicineServiceException {
		if (StringUtils.isEmpty(text) || " ".equalsIgnoreCase(text)) {
			throw new MedicineServiceException("Please enter some search text");
		}
		List<MedicineEntity> medicines = medicineDao.fetchByName(text);

		if (CollectionUtils.isEmpty(medicines)) {
			throw new MedicineServiceException("No records found");
		}

		List<MedicineBean> beans = new ArrayList<>();
		for (MedicineEntity entity : medicines) {
			MedicineBean bean = BeanCreatorUtil.medicine(entity);
			beans.add(bean);
		}
		return beans;
	}

	public int delete(int medId) {
		return medicineDao.delete(medId);
	}

}
