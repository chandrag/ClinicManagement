package com.icare.services;

import java.text.ParseException;
import java.util.List;
import java.util.Queue;

import com.icare.beans.AppointmentBean;
import com.icare.beans.AppointmentTypeBean;
import com.icare.exceptions.AppointmentException;
import com.icare.exceptions.NoDataFoundException;

public interface AppointmentService {

	void save(AppointmentBean appointment) throws AppointmentException;

	AppointmentBean findById(int id) throws NoDataFoundException;

	void delete(AppointmentBean appointment) throws NoDataFoundException;

	void update(AppointmentBean appointment) throws NoDataFoundException,
			ParseException;

	List<AppointmentTypeBean> fetchAll() throws NoDataFoundException;

	Queue<AppointmentBean> fetchTodaysAppointments()
			throws NoDataFoundException;

	int changeStatus(int id, String status);

}
