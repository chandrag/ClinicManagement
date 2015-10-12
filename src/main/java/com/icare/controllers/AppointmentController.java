package com.icare.controllers;

import static com.icare.utils.MessageConstants.MESSAGE;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icare.beans.AppointmentBean;
import com.icare.beans.AppointmentTypeBean;
import com.icare.exceptions.AppointmentException;
import com.icare.exceptions.NoDataFoundException;
import com.icare.services.AppointmentService;

@Controller
@RequestMapping(value = "appointment")
public class AppointmentController {

	static final Logger LOGGER = LoggerFactory
			.getLogger(AppointmentController.class);

	public static final String PATIENT_QUEUE = "PatientQueue";
	public static final String APPOINTMENT_DATE = "{date}";
	public static final String APPOINTMENT_TIME = "{time}";
	public static final String APPOINTMENT_ADD_SUCCESS = "Your appointment is scheduled on "
			+ APPOINTMENT_DATE + " at time " + APPOINTMENT_TIME;
	public static final String APPOINTMENT_HOME = "AppointmentHome";
	public static final String ADD_APPOINTMENT = "AddAppointment";
	public static final String VIEW_PATIENT_QUEUE = "PatientQueue";
	public static final String GET_ALL_APPOINTMENT_TYPES = "appointmenttypes";

	@Autowired
	private AppointmentService appointmentService;

	@RequestMapping
	public String renderAppointmentHome() {
		LOGGER.info("Rendering Appointment Home...");
		return APPOINTMENT_HOME;
	}

	@RequestMapping(value = GET_ALL_APPOINTMENT_TYPES, method = RequestMethod.GET)
	public @ResponseBody
	List<AppointmentTypeBean> getAllAppointmentTypes() {
		LOGGER.info("Getting all appointment types...");
		List<AppointmentTypeBean> types = new ArrayList<AppointmentTypeBean>();
		try {
			types = appointmentService.fetchAll();
			LOGGER.debug("Fetched Appointment Types : ", types);
		} catch (NoDataFoundException e) {
			LOGGER.error("No Appointment Types : ", e);
		}

		return types;
	}

	@RequestMapping(value = "add")
	public String renderAddAppointment() {
		LOGGER.info("Rendering Add Appointment...");
		return ADD_APPOINTMENT;
	}

	@RequestMapping(value = "create")
	public String addAppointment(AppointmentBean appointmentBean, Model model) {
		try {
			LOGGER.info("Creating appointment...");
			LOGGER.debug("Creating appointment : Appointment Bean - {} ",
					appointmentBean);
			appointmentService.save(appointmentBean);
			LOGGER.debug("Appointment Created Successfully...");

			String appointmentAddSuccess = APPOINTMENT_ADD_SUCCESS;
			appointmentAddSuccess = appointmentAddSuccess.replace(
					APPOINTMENT_DATE, appointmentBean.getDate());
			appointmentAddSuccess = appointmentAddSuccess.replace(
					APPOINTMENT_TIME, appointmentBean.getTime());

			model.addAttribute(MESSAGE, appointmentAddSuccess);
		} catch (AppointmentException e) {
			LOGGER.error("Exception occured while creating appointment : {}", e);
		}
		return renderAddAppointment();
	}

	@RequestMapping(value = "queue")
	public String renderPatientQueue(Model model) {
		LOGGER.info("Rendering Patient Queue...");

		try {
			Queue<AppointmentBean> queue = appointmentService
					.fetchTodaysAppointments();
			LOGGER.debug("Todays appointment queue : {}", queue.size());
			model.addAttribute(PATIENT_QUEUE, queue);
		} catch (NoDataFoundException e) {
			LOGGER.error(
					"Exception occured while fetching today's appoinments: {}",
					e);
		}

		return VIEW_PATIENT_QUEUE;
	}

	@RequestMapping(value = "changestatus")
	public String changeStatus(@ModelAttribute("p") Integer appointmentId,
			@ModelAttribute("s") String status, Model model) {
		appointmentService.changeStatus(appointmentId, status);
		return renderPatientQueue(model);
	}

}
