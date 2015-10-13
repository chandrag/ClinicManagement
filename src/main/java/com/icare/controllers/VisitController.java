package com.icare.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icare.beans.VisitBean;
import com.icare.exceptions.VisitException;
import com.icare.services.VisitService;
import com.icare.utils.MessageConstants;

@Controller
@RequestMapping(value = "visitshome")
public class VisitController {

	private static final String MOD_VISITS = "Visits";
	private static final String PAGE_PRESCRIPTION_SLIP = "PrescriptionSlip";
	private static final String MODEL_VISIT = "visit";
	private static final String DETAILS_UPDATED_SUCCESSFULLY = "Details updated successfully";
	private static final String VISIT_RECORD_CREATED_SUCCESSFULLY = "Visit record created successfully";
	public static final String UPDATE_VISIT = "UpdateVisit";
	public static final String SEARCH_VISITS = "SearchVisits";
	public static final String ADD_VISIT = "AddVisit";

	static final Logger LOGGER = LoggerFactory.getLogger(VisitController.class);

	@Autowired
	private VisitService visitService;

	@RequestMapping(value = "createvisit")
	public String renderCreateVisit() {
		LOGGER.info("Rendering Create Visit...");
		return ADD_VISIT;
	}

	@RequestMapping(value = "create")
	public String save(VisitBean visitBean, Model model) {
		try {
			LOGGER.info("Creating Visit...");
			LOGGER.debug("Visit Bean : {}", visitBean);
			visitService.save(visitBean);
			LOGGER.info("Visit Saved Successfully...");
			model.addAttribute(MessageConstants.MESSAGE,
					VISIT_RECORD_CREATED_SUCCESSFULLY);
		} catch (VisitException e) {
			LOGGER.error("Exception occured while saving visit : {}", e);
			model.addAttribute(MessageConstants.MESSAGE, e.getMessage());
		}
		return renderCreateVisit();
	}

	@RequestMapping(value = "search")
	public String renderFetchVisits() {
		LOGGER.info("Rendering Search Visits...");
		return SEARCH_VISITS;
	}

	@RequestMapping(value = "fetch")
	public String fetchByPatientId(
			@ModelAttribute("patientId") Integer patientId, Model model) {
		fetchVisit(patientId, model);
		return renderFetchVisits();
	}

	private List<VisitBean> fetchVisit(Integer patientId, Model model) {
		List<VisitBean> visits = null;
		try {
			LOGGER.info("Fetching Visits...");
			LOGGER.debug("PatientId : {}", patientId);
			visits = visitService.fetchByPatientId(patientId);
			model.addAttribute(MOD_VISITS, visits);
			LOGGER.debug("Visits Fetched : {}", visits);
			LOGGER.info("Visits fetched successfully...");
		} catch (VisitException e) {
			LOGGER.error("Exception occured while fetching patient : {}", e);
			model.addAttribute(MessageConstants.MESSAGE, e.getMessage());
		}
		return visits;
	}

}
