package com.icare.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icare.beans.PatientBean;
import com.icare.exceptions.PatientServiceException;
import com.icare.services.PatientService;
import com.icare.services.VisitService;
import com.icare.utils.MessageConstants;
import com.icare.utils.ViewNames;

@Controller
@RequestMapping(value = "patient")
public class PatientController {

	static final Logger LOGGER = LoggerFactory
			.getLogger(PatientController.class);

	@Autowired
	private PatientService patientService;

	@Autowired
	private VisitService visitService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String renderAddPatient() {
		return ViewNames.RegisterPatient.name();
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String addPatient(PatientBean patientBean, Model model) {
		try {
			patientService.save(patientBean);
			model.addAttribute(MessageConstants.MESSAGE,
					MessageConstants.PATIENT_ADD_SUCCESS);
		} catch (PatientServiceException e) {
			LOGGER.error("Exceptions occured while Adding Patient : {}", e);
			model.addAttribute(MessageConstants.MESSAGE, e.getMessage());
		}
		return renderAddPatient();
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String renderSearchPatient() {
		return ViewNames.SearchPatient.name();
	}

}
