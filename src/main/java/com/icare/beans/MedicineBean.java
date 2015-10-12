package com.icare.beans;

public class MedicineBean {

	private int id;
	private String name;
	private String manufacturer;
	private String type;
	private String unit;

	public MedicineBean() {

	}

	public MedicineBean(String name) {
		super();
		this.name = name;
	}

	public MedicineBean(int id) {
		super();
		this.id = id;
	}

	public MedicineBean(int id, String name, String manufacturer, String type,
			String unit) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return "MedicineBean [id=" + id + ", name=" + name + ", manufacturer="
				+ manufacturer + ", type=" + type + ", unit=" + unit + "]";
	}

}
