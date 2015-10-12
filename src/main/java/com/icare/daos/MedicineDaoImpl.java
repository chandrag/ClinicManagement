package com.icare.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icare.entities.MedicineEntity;

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class MedicineDaoImpl implements MedicineDao {

	private static final String QUERY_DELETE_BY_ID = "DELETE FROM MedicineEntity me WHERE me.id=:id";
	private static final String QUERY_FETCH_BY_NAME = "SELECT me FROM "
			+ "MedicineEntity me WHERE me.name LIKE :name";

	@Autowired
	private SessionFactory factory;

	@Transactional(readOnly = false)
	@Override
	public void save(MedicineEntity medicine) {
		factory.getCurrentSession().save(medicine);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MedicineEntity> fetchByName(String text) {
		Query query = factory.getCurrentSession().createQuery(
				QUERY_FETCH_BY_NAME);
		text = "%" + text + "%";
		query.setParameter("name", text);
		List<MedicineEntity> medicines = query.list();
		return medicines;
	}

	@Transactional(readOnly = false)
	@Override
	public int delete(int medId) {
		Query query = factory.getCurrentSession().createQuery(
				QUERY_DELETE_BY_ID);
		query.setParameter("id", medId);
		return query.executeUpdate();
	}

}
