package com.icare.daos;

import java.util.List;

import com.icare.entities.AppointmentTypeEntity;
import com.icare.exceptions.NoDataFoundException;

public interface AppointmentTypeDao {

	void save(AppointmentTypeEntity appointmentType);

	AppointmentTypeEntity findById(int id) throws NoDataFoundException;

	List<AppointmentTypeEntity> fetchAll() throws NoDataFoundException;

	void delete(AppointmentTypeEntity appointmentType);

}
