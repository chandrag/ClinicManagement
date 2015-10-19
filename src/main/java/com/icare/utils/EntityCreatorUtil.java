package com.icare.utils;

import com.icare.beans.PatientBean;
import com.icare.entities.PatientEntity;

public final class EntityCreatorUtil {

	public static PatientEntity createPatientEntity(PatientBean patientBean) {
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
		patientEntity.setDiseaseHistory(patientBean.getDiseaseHistory());
		patientEntity.setAllergies(patientBean.getAllergies());
		return patientEntity;
	}
}
