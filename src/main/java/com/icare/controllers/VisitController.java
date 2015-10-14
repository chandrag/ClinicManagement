package com.icare.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icare.services.VisitService;

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

	@RequestMapping(value = "search")
	public String renderFetchVisits() {
		LOGGER.info("Rendering Search Visits...");
		return SEARCH_VISITS;
	}

}
