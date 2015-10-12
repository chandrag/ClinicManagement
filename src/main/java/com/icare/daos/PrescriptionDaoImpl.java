package com.icare.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icare.entities.PrescriptionEntity;

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class PrescriptionDaoImpl implements PrescriptionDao {

	private static final String QUERY_FETCH_BY_VISIT_ID = "SELECT pe FROM PrescriptionEntity pe WHERE pe.visit.id=:visitId";

	@Autowired
	private SessionFactory factory;

	@Transactional(readOnly = false)
	@Override
	public void save(PrescriptionEntity prescription) {
		factory.getCurrentSession().save(prescription);
	}

	@Override
	public void update(PrescriptionEntity prescription) {
		factory.getCurrentSession().update(prescription);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PrescriptionEntity> fetchByVisitId(int visitId) {
		Query query = factory.getCurrentSession().createQuery(
				QUERY_FETCH_BY_VISIT_ID);
		query.setParameter("visitId", visitId);
		List<PrescriptionEntity> prescriptions = query.list();
		return prescriptions;
	}
}
