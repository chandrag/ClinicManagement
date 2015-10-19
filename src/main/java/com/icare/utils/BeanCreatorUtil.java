package com.icare.utils;

import com.icare.beans.PatientBean;
import com.icare.entities.PatientEntity;

public final class BeanCreatorUtil {

	public static PatientBean createPatientBean(PatientEntity entity) {
		PatientBean bean = new PatientBean();
		bean.setAddress(entity.getAddress());
		bean.setAge(entity.getAge());
		bean.setContactNo(entity.getContactNo());
		bean.setFees(entity.getFees());
		bean.setId(entity.getId());
		bean.setMrdNo(entity.getMrdNo());
		bean.setName(entity.getName());
		bean.setProcedureFees(entity.getProcedureFees());
		bean.setReferredBy(entity.getReferredBy());
		bean.setSex(entity.getSex());
		bean.setDiseaseHistory(entity.getDiseaseHistory());
		bean.setAllergies(entity.getAllergies());
		return bean;
	}

}
