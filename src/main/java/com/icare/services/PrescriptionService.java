package com.icare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icare.daos.MedicineDao;
import com.icare.daos.PrescriptionDao;

@Service
public class PrescriptionService {

	@Autowired
	private PrescriptionDao prescriptionDao;

	@Autowired
	private MedicineDao medicineDao;

}
