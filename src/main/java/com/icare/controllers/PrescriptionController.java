package com.icare.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icare.services.MedicineService;
import com.icare.services.PrescriptionService;

@Controller
@RequestMapping("prescription")
public class PrescriptionController {

	private static final String VI = "vi";
	private static final String SEARCH_PRESCRIPTION = "SearchPrescription";
	private static final String UPDATE_PRESCRIPTION = "UpdatePrescription";
	private static final String ADD_PRESCRIPTION = "AddPrescription";

	private static final String MOD_PRESCRIPTIONS = "prescriptions";
	private static final String PRESCRIPTION_ADDED_SUCCESSFULLY = "Prescription "
			+ "added successfully";

	static final Logger LOGGER = LoggerFactory
			.getLogger(PrescriptionController.class);

	@Autowired
	private PrescriptionService prescriptionService;

	@Autowired
	private MedicineService medicineService;

}
