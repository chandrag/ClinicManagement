package com.icare.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.icare.beans.PatientBean;
import com.icare.exceptions.NoDataFoundException;
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

	@RequestMapping(value = "save", method = RequestMethod.POST)
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

	@RequestMapping(value = "searchby", method = RequestMethod.GET)
	public ModelAndView searchBy(@ModelAttribute("searchTxt") String name) {
		ModelAndView mav = new ModelAndView(ViewNames.SearchPatient.name());
		try {
			List<PatientBean> patients = patientService.searchPatient(name);
			mav.addObject("patients", patients);
		} catch (NoDataFoundException e) {
			mav.addObject(MessageConstants.MESSAGE, e.getMessage());
		}
		return mav;
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView editPatient(@ModelAttribute("pid") Integer patientId) {
		ModelAndView modelAndView = new ModelAndView(
				ViewNames.RegisterPatient.name());
		PatientBean patientBean = patientService.findById(patientId);
		modelAndView.addObject("patient", patientBean);
		return modelAndView;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView deletePatient(@ModelAttribute("pid") Integer patientId) {
		ModelAndView modelAndView = new ModelAndView(
				ViewNames.SearchPatient.name());
		patientService.delete(patientId);
		return modelAndView;
	}

}
