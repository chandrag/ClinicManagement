package com.icare.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icare.daos.AppointmentDao;
import com.icare.daos.AppointmentTypeDao;
import com.icare.daos.PatientDao;

@Service
public class AppointmentService {

	static final Logger LOGGER = LoggerFactory
			.getLogger(AppointmentService.class);

	@Autowired
	private AppointmentDao appointmentDao;

	@Autowired
	private AppointmentTypeDao appointmentTypeDao;

	@Autowired
	private PatientDao patientDao;

}
