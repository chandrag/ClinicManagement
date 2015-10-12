package com.icare.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexViewController {

	static final Logger LOGGER = LoggerFactory
			.getLogger(IndexViewController.class);

	public static final String INDEX = "Index";
	public static final String VISITS_HOME = "VisitsHome";

	@RequestMapping(value = "index")
	public String renderIndex() {
		LOGGER.info("Rendering Index...");
		return INDEX;
	}

	@RequestMapping(value = "visitshome")
	public String renderVisitsHome() {
		LOGGER.info("Rendering Visits Home...");
		return VISITS_HOME;
	}

}
