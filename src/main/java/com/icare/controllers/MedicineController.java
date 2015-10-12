package com.icare.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icare.beans.MedicineBean;
import com.icare.exceptions.MedicineServiceException;
import com.icare.services.MedicineService;
import com.icare.utils.MessageConstants;

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

	@RequestMapping("add")
	public String addMedicine(MedicineBean medicineBean, Model model) {
		try {
			LOGGER.info("Adding medicine...");
			LOGGER.debug("Medicine Bean : {}", medicineBean);
			medicineService.save(medicineBean);
			LOGGER.info("Medicine added successfully...");
			model.addAttribute(MessageConstants.MESSAGE,
					MEDICINE_ADDED_SUCCESSFULLY);
		} catch (MedicineServiceException e) {
			LOGGER.error("Exception occured while adding medicine : {}", e);
			model.addAttribute(MessageConstants.MESSAGE, e.getMessage());
		}
		return renderAddMedicine();
	}

	@RequestMapping("searchmedi")
	public String renderSearchMedicine() {
		LOGGER.info("Rendering Search Medicine...");
		return SEARCH_MEDICINE;
	}

	@RequestMapping("search")
	public String searchMedicine(@ModelAttribute("txt") String text, Model model) {
		try {
			LOGGER.info("Searching Medicine...");
			LOGGER.debug("Search Text : {}", text);
			List<MedicineBean> medicines = medicineService.fetchByName(text);
			LOGGER.debug("Searched Medicines : {}", medicines);
			model.addAttribute(MOD_MEDICINES, medicines);
			model.addAttribute(MessageConstants.MOD_SUCCESS, Boolean.TRUE);
		} catch (MedicineServiceException e) {
			LOGGER.error("Exception occured while searching medicine : {}", e);
			model.addAttribute(MessageConstants.MESSAGE, e.getMessage());
			model.addAttribute(MessageConstants.MOD_SUCCESS, Boolean.FALSE);
		}

		return renderSearchMedicine();
	}

	@RequestMapping("delete")
	public String deleteMedicine(@ModelAttribute("mi") Integer medId,
			Model model) {
		LOGGER.info("Deleting Medicine...");
		LOGGER.debug("Medicine Id : {}", medId);
		medicineService.delete(medId);
		LOGGER.info("Medicine Deleted Successfully...");
		model.addAttribute(MessageConstants.MESSAGE,
				MEDICINE_DELETED_SUCCESSFULLY);
		model.addAttribute(MessageConstants.MOD_SUCCESS, Boolean.TRUE);
		return renderSearchMedicine();
	}
}
