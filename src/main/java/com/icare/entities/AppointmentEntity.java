package com.icare.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "appointment", schema = "icare")
public class AppointmentEntity {

	public enum Status {
		BOOKED("BOOKED"), CANCELLED("CANCELLED"), COMPLETED("COMPLETED"), ABSENT(
				"ABSENT");

		private String value;

		private Status(String stat) {
			this.value = stat;
		}

		public String getValue() {
			return value;
		}

	};

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	private String details;
	@ManyToOne
	@JoinColumn(name = "type_id")
	private AppointmentTypeEntity type;
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;
	private String status;

	public AppointmentEntity() {

	}

	public AppointmentEntity(Date date, String details,
			AppointmentTypeEntity type, PatientEntity patient, String status) {
		super();
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public AppointmentTypeEntity getType() {
		return type;
	}

	public void setType(AppointmentTypeEntity type) {
		this.type = type;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AppointmentEntity [id=" + id + ", date=" + date + ", time="
				+ time + ", details=" + details + ", type=" + type
				+ ", patient=" + patient + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppointmentEntity other = (AppointmentEntity) obj;
		if (id != other.id)
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
