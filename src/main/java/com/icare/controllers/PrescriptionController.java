package com.icare.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icare.beans.MedicineBean;
import com.icare.beans.PrescriptionBean;
import com.icare.exceptions.MedicineServiceException;
import com.icare.exceptions.PrescriptionServiceException;
import com.icare.services.MedicineService;
import com.icare.services.PrescriptionService;
import com.icare.utils.MessageConstants;

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

	@RequestMapping(value = "medicines", method = RequestMethod.GET)
	public @ResponseBody
	List<String> getAllEmployees(@ModelAttribute("text") String text) {
		LOGGER.info("Fetch all medicines...");
		List<String> medicines = new ArrayList<>();
		try {
			List<MedicineBean> meds = medicineService.fetchByName(text);
			for (MedicineBean medicineBean : meds) {
				medicines.add(medicineBean.getName());
			}
		} catch (MedicineServiceException e) {
			e.printStackTrace();
		}
		return medicines;
	}

	@RequestMapping("addpres")
	public String renderAddPrescription(@ModelAttribute(VI) Integer visitId,
			Model model) {
		LOGGER.info("Rendering add prescription...");
		LOGGER.debug("VisitId : " + visitId);
		try {
			List<PrescriptionBean> prescriptions = prescriptionService
					.fetchByVisitId(visitId);
			model.addAttribute(MOD_PRESCRIPTIONS, prescriptions);
		} catch (PrescriptionServiceException e) {
			LOGGER.error("Exception occured while fetching prescriptions : {}",
					e);
		}
		model.addAttribute(VI, visitId);
		return ADD_PRESCRIPTION;
	}

	@RequestMapping("add")
	public String addPrescription(PrescriptionBean prescriptionBean, Model model) {
		try {
			LOGGER.info("Adding prescription...");
			LOGGER.debug("Prescription Bean : {}", prescriptionBean);
			prescriptionService.save(prescriptionBean);
			LOGGER.info("Prescription added successfully...");
			model.addAttribute(MessageConstants.MESSAGE,
					PRESCRIPTION_ADDED_SUCCESSFULLY);
		} catch (PrescriptionServiceException e) {
			LOGGER.error("Exception occured while adding prescription : {}", e);
			model.addAttribute(MessageConstants.MESSAGE, e.getMessage());
		}
		return renderAddPrescription(prescriptionBean.getVisit().getId(), model);
	}

	@RequestMapping("updatepres")
	public String renderUpdatePres() {
		LOGGER.info("Rendering update prescription...");
		return UPDATE_PRESCRIPTION;
	}

	@RequestMapping("update")
	public String updatePrescription(PrescriptionBean prescription) {

		try {
			LOGGER.info("Updating prescription...");
			LOGGER.debug("Prescription Bean : {}", prescription);
			prescriptionService.update(prescription);
			LOGGER.info("Data updated successfully...");
		} catch (PrescriptionServiceException e) {
			LOGGER.error("Exception occured while updating prescription : {}",
					e);
		}

		return renderUpdatePres();
	}

	@RequestMapping("searchpres")
	public String renderSearchPrescription() {
		LOGGER.info("Searching prescription...");
		return SEARCH_PRESCRIPTION;
	}

	@RequestMapping("search")
	public String searchPrescription(@ModelAttribute(VI) Integer visitId,
			Model model) {

		try {
			LOGGER.info("Searching prescription...");
			LOGGER.debug("Visit Id : {}", visitId);
			List<PrescriptionBean> prescriptions = prescriptionService
					.fetchByVisitId(visitId);
			LOGGER.info("Prescriptions fetched successfully...");
			LOGGER.debug("Prescriptions size : {}", prescriptions.size());
			model.addAttribute(MOD_PRESCRIPTIONS, prescriptions);
		} catch (PrescriptionServiceException e) {
			LOGGER.error("Exception occured while fetching prescriptions : {}",
					e);
			model.addAttribute(MessageConstants.MOD_SUCCESS, Boolean.FALSE);
		}

		return renderSearchPrescription();

	}

}
