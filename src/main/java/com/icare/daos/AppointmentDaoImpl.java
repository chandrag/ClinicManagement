package com.icare.daos;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.icare.entities.AppointmentEntity;
import com.icare.exceptions.NoDataFoundException;
import com.icare.utils.MessageConstants;

@Repository
@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
public class AppointmentDaoImpl implements AppointmentDao {

	public static final String CHANGE_STATUS = "UPDATE AppointmentEntity SET status=:status WHERE id=:id";

	static final Logger LOGGER = LoggerFactory
			.getLogger(AppointmentDaoImpl.class);

	@Autowired
	private SessionFactory factory;

	@Transactional(readOnly = false)
	public void save(AppointmentEntity appointment) {
		LOGGER.debug("Saving Appointment : {}", appointment);
		factory.getCurrentSession().save(appointment);
	}

	@SuppressWarnings("unchecked")
	public AppointmentEntity findById(int id) throws NoDataFoundException {
		LOGGER.debug("Finding Appointment - Id : {}", id);
		Criteria criteria = factory.getCurrentSession().createCriteria(
				AppointmentEntity.class);
		criteria.add(Restrictions.eq("id", id));
		List<AppointmentEntity> list = criteria.list();
		if (CollectionUtils.isEmpty(list)) {
			throw new NoDataFoundException(MessageConstants.REC_NOT_FOUND);
		}
		LOGGER.debug("Searched Appointment : {}", list.size());
		return list.get(0);
	}

	@Transactional(readOnly = false)
	public void delete(AppointmentEntity appointment) {
		LOGGER.debug("Deleting Appointment : {}", appointment);
		factory.getCurrentSession().delete(appointment);
	}

	@Transactional(readOnly = false)
	public void update(AppointmentEntity appointment) {
		LOGGER.debug("Updating Appointment : {}", appointment);
		factory.getCurrentSession().update(appointment);
	}

	@Transactional(readOnly = false)
	public int changeStatus(int id, String status) {
		LOGGER.info("Changing Appointment Status...");
		LOGGER.debug(
				"Changing status for appointment Id :{} to new status : {}",
				id, status);
		Query query = factory.getCurrentSession().createQuery(CHANGE_STATUS);
		query.setParameter("status", status);
		query.setParameter("id", id);
		int rowsUpdated = query.executeUpdate();
		LOGGER.debug("Changed status. No of rows : {}", rowsUpdated);
		return rowsUpdated;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AppointmentEntity> fetchAppointmentsByDate(
			Date appointmentDate, List<String> statuses) {
		LOGGER.info("Fetching todays appointments...");
		Query query = factory
				.getCurrentSession()
				.createQuery(
						"SELECT ae FROM AppointmentEntity ae WHERE ae.date=:date AND ae.status IN (:status)");
		query.setParameter("date", appointmentDate);
		query.setParameterList("status", statuses);
		List<AppointmentEntity> list = query.list();
		LOGGER.debug("Appointments for today : {}", list.size());
		return list;
	}

}
