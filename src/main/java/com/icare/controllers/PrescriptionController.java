package com.icare.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icare.services.MedicineService;
import com.icare.services.PrescriptionService;
import com.icare.utils.ViewNames;

@Controller
@RequestMapping("prescription")
public class PrescriptionController {

	static final Logger LOGGER = LoggerFactory
			.getLogger(PrescriptionController.class);

	@Autowired
	private PrescriptionService prescriptionService;

	@Autowired
	private MedicineService medicineService;

	@RequestMapping
	public ModelAndView renderSpectaclePrescription() {
		ModelAndView mav = new ModelAndView(
				ViewNames.SpectaclePrescription.name());
		return mav;
	}

}
