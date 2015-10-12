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

import com.icare.entities.PatientEntity;
import com.icare.exceptions.NoDataFoundException;
import com.icare.utils.MessageConstants;

@Repository
@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
public class PatientDaoImpl implements PatientDao {

	static final Logger LOGGER = LoggerFactory.getLogger(PatientDaoImpl.class);

	@Autowired
	private SessionFactory factory;

	@Transactional(readOnly = false)
	public void save(PatientEntity patientModel) {
		LOGGER.debug("Saving Patient : {}", patientModel);
		factory.getCurrentSession().save(patientModel);
	}

	@Transactional(readOnly = false)
	public void update(PatientEntity patientModel) throws NoDataFoundException {
		LOGGER.debug("Updating Patient : {}", patientModel);
		factory.getCurrentSession().saveOrUpdate(patientModel);
	}

	@SuppressWarnings("unchecked")
	public PatientEntity search(int id) throws NoDataFoundException {
		LOGGER.debug("Searching Patient - PatientId : {}", id);
		Criteria criteria = factory.getCurrentSession().createCriteria(
				PatientEntity.class);
		criteria.add(Restrictions.eq("id", id));
		List<PatientEntity> list = criteria.list();
		if (CollectionUtils.isEmpty(list)) {
			throw new NoDataFoundException(MessageConstants.REC_NOT_FOUND);
		}
		LOGGER.debug("Searched Patients : {}", list.size());
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	public PatientEntity searchByName(String firstName, String lastName)
			throws NoDataFoundException {
		LOGGER.debug("Searching Patient - FirstName : {} and LastName : {}",
				firstName, lastName);
		Criteria criteria = factory.getCurrentSession().createCriteria(
				PatientEntity.class);
		criteria.add(Restrictions.or(Restrictions.eq("firstName", firstName),
				Restrictions.eq("lastName", lastName)));
		List<PatientEntity> list = criteria.list();
		if (CollectionUtils.isEmpty(list)) {
			throw new NoDataFoundException(MessageConstants.REC_NOT_FOUND);
		}
		LOGGER.debug("Searched Patient : {}", list.size());
		return list.get(0);
	}

	@Transactional(readOnly = false)
	public void delete(PatientEntity patientModel) {
		LOGGER.debug("Deleting Patient : {}", patientModel);
		factory.getCurrentSession().delete(patientModel);
	}

}
