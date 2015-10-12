package com.icare.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "icare", name = "medicine")
public class MedicineEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String manufacturer;
	private String type;
	private String unit;
	@OneToOne(mappedBy = "medicine", cascade = CascadeType.ALL)
	private PrescriptionEntity prescription;

	public MedicineEntity() {
	}

	public MedicineEntity(int id, String name, String manufacturer,
			String type, String unit) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.type = type;
		this.unit = unit;
	}

	public MedicineEntity(int id) {
		super();
		this.id = id;
	}

	public MedicineEntity(String name, String manufacturer, String type,
			String unit) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.type = type;
		this.unit = unit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public PrescriptionEntity getPrescription() {
		return prescription;
	}

	public void setPrescription(PrescriptionEntity prescription) {
		this.prescription = prescription;
	}

	@Override
	public String toString() {
		return "MedicineEntity [id=" + id + ", name=" + name
				+ ", manufacturer=" + manufacturer + ", type=" + type
				+ ", unit=" + unit + "]";
	}

}
