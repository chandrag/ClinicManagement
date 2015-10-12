package com.icare.beans;

import java.util.Date;

public class AppointmentBean implements Comparable<AppointmentBean> {

	private int id;
	private String date;
	private String time;
	private String details;
	private AppointmentTypeBean type;
	private PatientBean patient;
	private Date appointmentTime;
	private String status;

	public AppointmentBean() {

	}

	public AppointmentBean(String date, String time, String details,
			AppointmentTypeBean type, PatientBean patient, String status) {
		super();
		this.date = date;
		this.time = time;
		this.type = type;
		this.patient = patient;
		this.details = details;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public AppointmentTypeBean getType() {
		return type;
	}

	public void setType(AppointmentTypeBean type) {
		this.type = type;
	}

	public PatientBean getPatient() {
		return patient;
	}

	public void setPatient(PatientBean patient) {
		this.patient = patient;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Date appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AppointmentBean [id=" + id + ", date=" + date + ", time="
				+ time + ", details=" + details + ", type=" + type
				+ ", patient=" + patient + ", appointmentTime="
				+ appointmentTime + ", status=" + status + "]";
	}

	@Override
	public int compareTo(AppointmentBean anotherAppointment) {
		boolean isBefore = this.appointmentTime.before(anotherAppointment
				.getAppointmentTime());
		int compared = 1;
		if (isBefore) {
			compared = -1;
		}
		return compared;
	}
}
