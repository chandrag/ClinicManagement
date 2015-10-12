package com.icare.daos;

import java.util.Date;
import java.util.List;

import com.icare.entities.AppointmentEntity;
import com.icare.exceptions.NoDataFoundException;

public interface AppointmentDao {

	void save(AppointmentEntity appointment);

	AppointmentEntity findById(int id) throws NoDataFoundException;

	void delete(AppointmentEntity appointment);

	void update(AppointmentEntity appointment);

	List<AppointmentEntity> fetchAppointmentsByDate(Date appointmentDate,
			List<String> statuses);

	int changeStatus(int id, String status);

}
