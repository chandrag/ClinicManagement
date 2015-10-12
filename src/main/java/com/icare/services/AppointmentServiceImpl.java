package com.icare.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.icare.beans.AppointmentBean;
import com.icare.beans.AppointmentTypeBean;
import com.icare.daos.AppointmentDao;
import com.icare.daos.AppointmentTypeDao;
import com.icare.daos.PatientDao;
import com.icare.entities.AppointmentEntity;
import com.icare.entities.AppointmentEntity.Status;
import com.icare.entities.AppointmentTypeEntity;
import com.icare.entities.PatientEntity;
import com.icare.exceptions.AppointmentException;
import com.icare.exceptions.InvalidAppointmentDateException;
import com.icare.exceptions.NoDataFoundException;
import com.icare.utils.AppConstants;
import com.icare.utils.BeanCreatorUtil;
import com.icare.utils.DateUtil;
import com.icare.utils.EntityCreatorUtil;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	static final Logger LOGGER = LoggerFactory
			.getLogger(AppointmentServiceImpl.class);

	@Autowired
	private AppointmentDao appointmentDao;

	@Autowired
	private AppointmentTypeDao appointmentTypeDao;

	@Autowired
	private PatientDao patientDao;

	@Override
	public void save(AppointmentBean appointment) throws AppointmentException {

		try {
			LOGGER.debug("Saving Appointment : {}", appointment);
			Date appointmentDate = DateUtil.toDate(appointment.getDate(),
					AppConstants.DD_MMM_YYYY);
			LOGGER.debug("Appointment Date : {}", appointmentDate);

			if (!DateUtil.validateAppointmentDate(appointmentDate)) {
				throw new InvalidAppointmentDateException(
						"Appointment Date should be greater than or equal to today");
			}

			AppointmentTypeEntity appointmentType = appointmentTypeDao
					.findById(appointment.getType().getId());
			LOGGER.debug("Searched Appointment Type : {}", appointmentType);
			PatientEntity patient = patientDao.search(appointment.getPatient()
					.getId());
			LOGGER.debug("Searched Patient : {}", patient);
			AppointmentEntity appointmentModel = EntityCreatorUtil
					.createAppointment(appointment, appointmentType, patient);
			LOGGER.debug("Saving Appointment Mode : {}", appointmentModel);

			// Calculate appointment time
			calculateAppointmentTime(appointmentDate, appointmentModel);

			appointmentDao.save(appointmentModel);

			LOGGER.debug("Appointment Saved - Id : {}",
					appointmentModel.getId());
			appointment.setId(appointmentModel.getId());
			appointment.setTime(DateUtil.toString(appointmentModel.getTime(),
					AppConstants.HH_MM_SS));
		} catch (NoDataFoundException e) {
			LOGGER.error("Exception Occurred while creating appointment : {}",
					e);
			throw new AppointmentException("Unable to create appointment : "
					+ e.getMessage());
		} catch (ParseException e) {
			LOGGER.error("Date Parsing exception : {}", e);
			throw new AppointmentException(
					"Unable to create appointment Invalid Appointment Date or Time: "
							+ e.getMessage());
		}

	}

	/**
	 * The method checks if there are any appointments scheduled on the same
	 * date.
	 * <ol>
	 * <li>If no appointments are scheduled then the appointment time will be
	 * set to clinic start time</li>
	 * <li>If there are any appointments scheduled then time for this
	 * appointment would be the last appointment + 15mins</li>
	 * </ol>
	 */
	public void calculateAppointmentTime(Date appointmentDate,
			AppointmentEntity appointmentModel) throws ParseException {

		List<AppointmentEntity> allAppointments = appointmentDao
				.fetchAppointmentsByDate(
						appointmentDate,
						Arrays.asList(Status.BOOKED.getValue(),
								Status.ABSENT.getValue()));
		Date appointmentTime = null;
		if (CollectionUtils.isEmpty(allAppointments)) {
			String appointmentDateStr = DateUtil.toString(appointmentDate,
					AppConstants.DD_MMM_YYYY);
			appointmentTime = DateUtil.toDate(appointmentDateStr + " "
					+ "10:00 AM", AppConstants.DD_MMM_YYYY_HH_MM_SS);
		} else {
			LinkedList<AppointmentBean> appointments = new LinkedList<AppointmentBean>();
			for (AppointmentEntity model : allAppointments) {
				AppointmentBean bean = BeanCreatorUtil.appointment(model);
				appointments.add(bean);
			}
			Collections.sort(appointments);

			AppointmentBean appointmentBean = appointments.getLast();

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(DateUtil.toDate(appointmentBean.getTime(),
					AppConstants.DD_MMM_YYYY_HH_MM_SS));
			calendar.add(Calendar.MINUTE, 15);
			appointmentTime = calendar.getTime();
		}
		appointmentModel.setTime(appointmentTime);

	}

	@Override
	public AppointmentBean findById(int id) throws NoDataFoundException {
		LOGGER.debug("Finding Appointment - Id : {}", id);
		AppointmentEntity appointmentModel = appointmentDao.findById(id);
		LOGGER.debug("Appointment Searched : {}", appointmentModel);
		AppointmentBean bean = BeanCreatorUtil.appointment(appointmentModel);
		LOGGER.debug("Searched Appointment Bean : {}", bean);
		return bean;

	}

	@Override
	public void delete(AppointmentBean appointment) throws NoDataFoundException {
		LOGGER.debug("Deleting Appointment : {}", appointment);
		PatientEntity patient = patientDao.search(appointment.getPatient()
				.getId());
		LOGGER.debug("Searched Patient : {}", patient);
		AppointmentTypeEntity type = appointmentTypeDao.findById(appointment
				.getType().getId());
		LOGGER.debug("Searched Appointment Type : {}", type);
		try {
			AppointmentEntity appointmentModel = EntityCreatorUtil
					.createAppointment(appointment, type, patient);
			LOGGER.debug("Deleting Appointment : {}", appointmentModel);
			appointmentDao.delete(appointmentModel);
		} catch (ParseException e) {
			LOGGER.error("Exception occured while deleting appointment : {}", e);
		}
		LOGGER.info("Appointment Deleted...");
	}

	@Override
	public void update(AppointmentBean bean) throws NoDataFoundException,
			ParseException {
		LOGGER.info("Updating Appointment...");
		LOGGER.debug("Updating Appointment : {}", bean);
		AppointmentEntity model = appointmentDao.findById(bean.getId());
		LOGGER.debug("Updating Searched Appointment : {}", model);
		if (null != model) {
			EntityCreatorUtil.updateAppointment(model, bean);
			LOGGER.debug("Updated Appointment : {}", model);
			appointmentDao.update(model);
		}
		LOGGER.info("Appointment Updated Successfully...");
	}

	@Override
	public List<AppointmentTypeBean> fetchAll() throws NoDataFoundException {
		LOGGER.info("Fetching All Appointment Types...");
		List<AppointmentTypeEntity> types = appointmentTypeDao.fetchAll();
		LOGGER.debug("Searched Appointment Types - Size : {}", types.size());
		List<AppointmentTypeBean> beans = new ArrayList<AppointmentTypeBean>();
		for (AppointmentTypeEntity model : types) {
			AppointmentTypeBean bean = BeanCreatorUtil.appointmentType(model);
			beans.add(bean);
		}
		LOGGER.debug("Searched Appointment Beans - Size : {}", beans.size());
		return beans;
	}

	@Override
	public Queue<AppointmentBean> fetchTodaysAppointments()
			throws NoDataFoundException {
		LOGGER.info("Fetching todays appointments...");
		final Date today = new Date();
		List<AppointmentEntity> todaysAppointments = appointmentDao
				.fetchAppointmentsByDate(
						today,
						Arrays.asList(Status.BOOKED.getValue(),
								Status.ABSENT.getValue()));
		LOGGER.debug("Sorting Todays appointments...");
		List<AppointmentBean> appointments = new LinkedList<AppointmentBean>();
		for (AppointmentEntity model : todaysAppointments) {
			AppointmentBean bean = BeanCreatorUtil.appointment(model);
			appointments.add(bean);
		}
		LinkedList<AppointmentBean> patientQueue = createPatientQueue(appointments);
		LOGGER.info("Todays appoinments fetched...");
		return patientQueue;
	}

	private LinkedList<AppointmentBean> createPatientQueue(
			List<AppointmentBean> appointments) {
		Collections.sort(appointments);
		LinkedList<AppointmentBean> patientQueue = new LinkedList<AppointmentBean>(
				appointments);
		return patientQueue;
	}

	@Override
	public int changeStatus(int id, String status) {
		return appointmentDao.changeStatus(id, status);
	}
}
