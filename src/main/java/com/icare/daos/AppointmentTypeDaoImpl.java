package com.icare.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.icare.entities.AppointmentTypeEntity;
import com.icare.exceptions.NoDataFoundException;
import com.icare.utils.MessageConstants;

@Repository
@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
public class AppointmentTypeDaoImpl implements AppointmentTypeDao {

	static final Logger LOGGER = LoggerFactory
			.getLogger(AppointmentTypeDaoImpl.class);

	@Autowired
	private SessionFactory factory;

	@Transactional(readOnly = false)
	public void save(AppointmentTypeEntity appointmentType) {
		LOGGER.debug("Saving AppointmentType : {}", appointmentType);
		factory.getCurrentSession().save(appointmentType);
	}

	@SuppressWarnings("unchecked")
	public AppointmentTypeEntity findById(int id) throws NoDataFoundException {
		LOGGER.debug("Searching AppointmentType - Id : {}", id);
		Criteria criteria = factory.getCurrentSession().createCriteria(
				AppointmentTypeEntity.class);
		criteria.add(Restrictions.eq("id", id));
		List<AppointmentTypeEntity> list = criteria.list();
		if (CollectionUtils.isEmpty(list)) {
			throw new NoDataFoundException(MessageConstants.REC_NOT_FOUND);
		}
		LOGGER.debug("Searched Appointment Types : {}", list.size());
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<AppointmentTypeEntity> fetchAll() throws NoDataFoundException {
		LOGGER.info("Fetching all appointment types...");
		Criteria criteria = factory.getCurrentSession().createCriteria(
				AppointmentTypeEntity.class);
		List<AppointmentTypeEntity> list = criteria.list();
		if (CollectionUtils.isEmpty(list)) {
			throw new NoDataFoundException(MessageConstants.REC_NOT_FOUND);
		}
		LOGGER.debug("Fetched appoinment types : {}", list.size());
		return list;
	}

	@Transactional(readOnly = false)
	public void delete(AppointmentTypeEntity appointmentType) {
		LOGGER.debug("Deleting Appointment Type : {}", appointmentType);
		factory.getCurrentSession().delete(appointmentType);
	}

}
