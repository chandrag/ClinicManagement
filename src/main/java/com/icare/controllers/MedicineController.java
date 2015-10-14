package com.icare.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icare.services.MedicineService;

@Controller
@RequestMapping(value = "medicine")
public class MedicineController {

	private static final String MOD_MEDICINES = "Medicines";
	private static final String MEDICINE_DELETED_SUCCESSFULLY = "Medicine deleted successfully";
	private static final String MEDICINE_ADDED_SUCCESSFULLY = "Medicine added successfully";
	private static final String ADD_MEDICINE = "AddMedicine";
	private static final String SEARCH_MEDICINE = "SearchMedicine";
	private static final String MEDICINE_HOME = "MedicineHome";

	static final Logger LOGGER = LoggerFactory
			.getLogger(MedicineController.class);

	@Autowired
	private MedicineService medicineService;

	@RequestMapping("home")
	public String renderMedicineHome() {
		LOGGER.info("Rendering Medicine Home...");
		return MEDICINE_HOME;
	}

	@RequestMapping("addmedi")
	public String renderAddMedicine() {
		LOGGER.info("Rendering add medicine...");
		return ADD_MEDICINE;
	}

	@RequestMapping("searchmedi")
	public String renderSearchMedicine() {
		LOGGER.info("Rendering Search Medicine...");
		return SEARCH_MEDICINE;
	}

}
