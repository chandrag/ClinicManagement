package com.icare.services;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icare.beans.PatientBean;
import com.icare.daos.PatientDao;
import com.icare.entities.AddressEntity;
import com.icare.entities.ContactEntity;
import com.icare.entities.PatientEntity;
import com.icare.exceptions.NoDataFoundException;
import com.icare.exceptions.PatientServiceException;
import com.icare.utils.BeanCreatorUtil;
import com.icare.utils.EntityCreatorUtil;

@Service
public class PatientServiceImpl implements PatientService {

	static final Logger LOGGER = LoggerFactory
			.getLogger(PatientServiceImpl.class);

	@Autowired
	private PatientDao patientDao;

	public void save(PatientBean patientBean) throws PatientServiceException {
		LOGGER.debug("Saving Patient : {}", patientBean);
		ContactEntity contact = EntityCreatorUtil.createContact(patientBean
				.getContact());
		LOGGER.debug("Searched Contact : {}", contact);
		AddressEntity address = EntityCreatorUtil.createAddress(patientBean
				.getContact().getAddress());
		LOGGER.debug("Searched Address : {}", address);
		try {
			PatientEntity patientModel = EntityCreatorUtil
					.createPatient(patientBean);
			LOGGER.debug("Created Patient : {}", patientModel);
			patientModel.setContact(contact);
			contact.setPatient(patientModel);

			contact.setAddress(address);
			address.setContact(contact);
			LOGGER.debug("Saving Patient : {}", patientModel);
			patientDao.save(patientModel);
			LOGGER.debug("Patient Saved - Id : {}", patientModel.getId());
			patientBean.setId(patientModel.getId());
		} catch (IOException e) {
			LOGGER.error("Exception occured while uploading profile pic : {}",
					e);
			throw new PatientServiceException(
					"Exception ocurred while uploading profile pic : {}", e);
		}

	}

	public void update(PatientBean patientTO) throws NoDataFoundException {
		LOGGER.debug("Updating Patient : {}", patientTO);
		PatientEntity patientModel = patientDao.search(patientTO.getId());
		LOGGER.debug("Searched Patient Model : {}", patientModel);
		if (null != patientModel) {
			EntityCreatorUtil.updatePatient(patientTO, patientModel);
			LOGGER.debug("Updated Patient Model : {}", patientModel);
			patientDao.update(patientModel);
		}
	}

	public PatientBean search(int id) throws NoDataFoundException {
		LOGGER.debug("Searching Patient - Id : ", id);
		PatientEntity patientModel = patientDao.search(id);
		LOGGER.debug("Searched Patient Model : {}", patientModel);
		PatientBean patientTO = null;
		if (null != patientModel) {
			patientTO = BeanCreatorUtil.patient(patientModel);
		}
		LOGGER.debug("Searched PatientTO : {}", patientTO);
		return patientTO;
	}

	public PatientBean searchByName(String firstName, String lastName)
			throws NoDataFoundException {
		LOGGER.debug("Searching Patient - FirstName : {} and LastName : {}",
				firstName, lastName);
		PatientEntity patientModel = patientDao.searchByName(firstName,
				lastName);
		LOGGER.debug("Searched Patient : {}", patientModel);
		PatientBean patientTO = null;
		if (null != patientModel) {
			patientTO = BeanCreatorUtil.patient(patientModel);
		}
		LOGGER.debug("Searched PatientTO : {}", patientTO);
		return patientTO;
	}

	public void delete(int patientId) throws NoDataFoundException {
		LOGGER.debug("Deleting Patient - Id : {}", patientId);
		PatientEntity patientModel = patientDao.search(patientId);
		LOGGER.debug("Searched Patient for deleting : {}", patientModel);
		patientDao.delete(patientModel);
	}

}
