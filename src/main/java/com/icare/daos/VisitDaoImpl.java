package com.icare.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icare.entities.VisitEntity;

@Repository
@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
public class VisitDaoImpl implements VisitDao {

	private static final String QUERY_UPDATE_VISIT = "UPDATE VisitEntity ve "
			+ "SET ve.problems=:problems,ve.symptoms=:symptoms,"
			+ "ve.allergies=:allergies,ve.prescription=:prescription,"
			+ "ve.testResults=:testResults,ve.visitDt=:visitDt WHERE ve.id=:id";

	private static final String QUERY_SEARCH_VISIT_BY_PATIENTID = "SELECT ve FROM "
			+ "VisitEntity ve WHERE ve.patient.id=:patientId";

	private static final String QUERY_FIND_VISIT_BY_ID = "SELECT ve FROM "
			+ "VisitEntity ve WHERE ve.id=:id";

	static final Logger LOGGER = LoggerFactory.getLogger(VisitDaoImpl.class);

	@Autowired
	private SessionFactory factory;

	@Transactional(readOnly = false)
	@Override
	public void save(VisitEntity visitEntity) {
		factory.getCurrentSession().save(visitEntity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VisitEntity> fetchByPatientId(int patientId) {
		Query query = factory.getCurrentSession().createQuery(
				QUERY_SEARCH_VISIT_BY_PATIENTID);
		query.setParameter("patientId", patientId);
		List<VisitEntity> visits = query.list();
		return visits;
	}

	@Transactional(readOnly = false)
	@Override
	public void update(VisitEntity visitEntity) {
		factory.getCurrentSession().update(visitEntity);
		// Query query = factory.getCurrentSession().createQuery(
		// QUERY_UPDATE_VISIT);
		// query.setParameter("id", visitEntity.getId());
		// query.setParameter("problems", visitEntity.getProblems());
		// query.setParameter("symptoms", visitEntity.getSymptoms());
		// query.setParameter("allergies", visitEntity.getAllergies());
		// query.setParameter("testResults", visitEntity.getTestResults());
		// query.setParameter("visitDt", visitEntity.getVisitDt());
		// return query.executeUpdate();
	}

	@Override
	public VisitEntity findById(int visitId) {
		Query query = factory.getCurrentSession().createQuery(
				QUERY_FIND_VISIT_BY_ID);
		query.setParameter("id", visitId);
		VisitEntity visitEntity = (VisitEntity) query.uniqueResult();
		return visitEntity;
	}

}
