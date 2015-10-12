package com.icare.daos;

import java.util.List;

import com.icare.entities.MedicineEntity;

public interface MedicineDao {

	void save(MedicineEntity medicine);

	List<MedicineEntity> fetchByName(String text);

	int delete(int medId);

}
