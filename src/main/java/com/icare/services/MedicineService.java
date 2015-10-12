package com.icare.services;

import java.util.List;

import com.icare.beans.MedicineBean;
import com.icare.exceptions.MedicineServiceException;

public interface MedicineService {

	void save(MedicineBean medicineBean) throws MedicineServiceException;

	List<MedicineBean> fetchByName(String text) throws MedicineServiceException;

	int delete(int medId);

}
