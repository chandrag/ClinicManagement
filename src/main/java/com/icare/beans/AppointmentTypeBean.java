package com.icare.beans;

public class AppointmentTypeBean {

	private int id;
	private String name;

	public AppointmentTypeBean() {

	}

	public AppointmentTypeBean(int id) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return "AppointmentTypeBean [id=" + id + ", name=" + name + "]";
	}

}
