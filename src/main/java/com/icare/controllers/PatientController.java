package com.icare.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icare.beans.PatientBean;
import com.icare.beans.VisitBean;
import com.icare.exceptions.NoDataFoundException;
import com.icare.exceptions.PatientServiceException;
import com.icare.exceptions.VisitException;
import com.icare.services.PatientService;
import com.icare.services.VisitService;
import com.icare.utils.MessageConstants;

@Controller
@RequestMapping(value = "patient")
public class PatientController {

	public static final String MOD_VISITS = "Visits";

	private static final String VISIT_MESSAGE = "VisitMessage";

	static final Logger LOGGER = LoggerFactory
			.getLogger(PatientController.class);

	public static final String PATIENT_MENUS = "PatientHome";
	public static final String ADD_PATIENT = "AddPatient";
	public static final String EDIT_PATIENT = "EditPatient";
	public static final String SEARCH_PATIENT = "SearchPatient";

	public static final String MOD_PATIENT = "PatientTo";
	public static final String PATIENT_ADD_SUCCESS = "Patient Added Successfully";
	public static final String PATIENT_UPDATE_SUCCESS = "Changes Saved Successfully";
	public static final String PATIENT_DELETE_SUCCESS = "Patient Deleted Successfully";
	public static final String PATIENT_NOT_FOUND = "Patient Not Found";

	@Autowired
	private PatientService patientService;

	@Autowired
	private VisitService visitService;

	@RequestMapping(value = "home")
	public String renderPatientHome() {
		return PATIENT_MENUS;
	}

	@RequestMapping(value = "addpatient")
	public String renderAddPatient() {
		return ADD_PATIENT;
	}

	@RequestMapping(value = "searchpatient")
	public String renderSearchPatient() {
		LOGGER.info("Rendering Search Patient...");
		return SEARCH_PATIENT;
	}

	@RequestMapping(value = "search")
	public String searchPatient(PatientBean patientTO, Model model) {
		try {
			LOGGER.info("Searching Patient for criteria : {}",
					patientTO.getSearchFor());
			PatientBean searchedPatient = null;

			switch (patientTO.getSearchFor()) {
			case 101:
				LOGGER.debug("Searching Patient : {}", patientTO);
				searchedPatient = patientService.search(Integer
						.parseInt(patientTO.getSearchText()));
				break;
			case 102:
				LOGGER.debug("Searching Patient : {}", patientTO);
				searchedPatient = patientService.searchByName(
						patientTO.getSearchText(), patientTO.getSearchText());
				break;
			default:
				break;
			}
			LOGGER.debug("Searched Patient : {}", searchedPatient);
			model.addAttribute(MOD_PATIENT, searchedPatient);
			List<VisitBean> visits = visitService
					.fetchByPatientId(searchedPatient.getId());
			model.addAttribute(MOD_VISITS, visits);
		} catch (NoDataFoundException e) {
			LOGGER.error("Exception occured while searching patient : {}", e);
			model.addAttribute(MessageConstants.MESSAGE, PATIENT_NOT_FOUND);
		} catch (VisitException e) {
			LOGGER.error("Exception occured while fetching visits : {}", e);
			model.addAttribute(VISIT_MESSAGE, e.getMessage());
		}
		return renderSearchPatient();
	}

	@RequestMapping(value = "create")
	public String addPatient(PatientBean patientTO, Model model) {
		LOGGER.info("Creating Patient...");
		LOGGER.debug("Creating Patient : {}", patientTO);
		try {
			patientService.save(patientTO);
			LOGGER.info("Patient Created Successfully...");
			model.addAttribute(MessageConstants.MESSAGE, PATIENT_ADD_SUCCESS);
		} catch (PatientServiceException e) {
			LOGGER.error("Exceptions occured while Adding Patient : {}", e);
			model.addAttribute(MessageConstants.MESSAGE, e.getMessage());
		}
		return renderAddPatient();
	}

	@RequestMapping(value = "editpatient")
	public String editPatient(Integer patientId, Model model) {
		try {
			LOGGER.info("Editing Patient..");
			LOGGER.debug("Searching Patient for Editing PatientId : {}",
					patientId);
			PatientBean searchedPatient = patientService.search(patientId);
			LOGGER.debug("Searched Patient for Editings : {}", searchedPatient);
			model.addAttribute(MOD_PATIENT, searchedPatient);
		} catch (NoDataFoundException e) {
			LOGGER.error(
					"Exception occured while searching patient for edit : {}",
					e);
		}
		return EDIT_PATIENT;
	}

	@RequestMapping(value = "fetchprofilepic")
	public void fetchProfilePic(@ModelAttribute("q") Integer patientId,
			HttpServletResponse response) {
		try {
			LOGGER.info("Fetching profile image...");
			LOGGER.debug("Searching Patient for Image PatientId : {}",
					patientId);
			PatientBean searchedPatient = patientService.search(patientId);
			LOGGER.debug("Searched Patient for Profile Image : {}",
					searchedPatient);

			OutputStream outputStream = response.getOutputStream();
			outputStream.write(searchedPatient.getProfileImageBytes());

		} catch (NoDataFoundException e) {
			LOGGER.error(
					"Exception occured while searching patient for edit : {}",
					e);
		} catch (IOException e) {
			LOGGER.error(
					"Exception occured while sending image content in response : {}",
					e);
		}
	}

	@RequestMapping(value = "savechanges")
	public String savePatientDetails(
			@ModelAttribute("PatientTo") PatientBean patientBean, Model model) {
		try {
			LOGGER.info("Saving Patient details after update...");
			LOGGER.debug("Saving Changes : {}", patientBean);
			patientService.update(patientBean);
			LOGGER.info("Update Successful...");
			model.addAttribute(MessageConstants.MESSAGE, PATIENT_UPDATE_SUCCESS);
		} catch (NoDataFoundException e) {
			LOGGER.error("Exception Occured while Updating : {}", e);
		}
		return editPatient(patientBean.getId(), model);
	}

	@RequestMapping(value = "deletepatient")
	public String deletePatient(Integer patientId, Model model) {
		try {
			LOGGER.info("Deleting Patient...");
			LOGGER.debug("Deleting Patient - PatientId : {}", patientId);
			patientService.delete(patientId);
			LOGGER.info("Patient Deleted Successfully...");
			model.addAttribute(MessageConstants.MESSAGE, PATIENT_DELETE_SUCCESS);
		} catch (NoDataFoundException e) {
			LOGGER.error("Exception occured while deleting patient : {}", e);
		}
		return renderSearchPatient();
	}

}
