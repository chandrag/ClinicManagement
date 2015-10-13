package com.icare.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icare.services.AppointmentService;
import com.icare.utils.ViewNames;

@Controller
@RequestMapping(value = "appointment")
public class AppointmentController {

	static final Logger LOGGER = LoggerFactory
			.getLogger(AppointmentController.class);

	@Autowired
	private AppointmentService appointmentService;

	@RequestMapping
	public String renderAppointmentHome() {
		return ViewNames.BookAppointment.name();
	}

	@RequestMapping(value = "book")
	public String renderBookAppointment() {
		return ViewNames.BookAppointment.name();
	}

}
