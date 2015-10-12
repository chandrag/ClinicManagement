package com.icare.entities;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "visit", schema = "icare")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;
	private String problems;
	private String symptoms;
	private String allergies;
	@Column(name = "test_results")
	private String testResults;
	@Temporal(TemporalType.DATE)
	@Column(name = "visit_dt")
	private Date visitDt;

	public VisitEntity() {
	}

	public VisitEntity(int id) {
		super();
		this.id = id;
	}

	public VisitEntity(PatientEntity patient, String problems, String symptoms,
			String allergies, String testResults, Date visitDt) {
		super();
		this.patient = patient;
		this.problems = problems;
		this.symptoms = symptoms;
		this.allergies = allergies;
		this.testResults = testResults;
		this.visitDt = visitDt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public String getProblems() {
		return problems;
	}

	public void setProblems(String problems) {
		this.problems = problems;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getTestResults() {
		return testResults;
	}

	public void setTestResults(String testResults) {
		this.testResults = testResults;
	}

	public Date getVisitDt() {
		return visitDt;
	}

	public void setVisitDt(Date visitDt) {
		this.visitDt = visitDt;
	}

	@Override
	public String toString() {
		return "VisitEntity [id=" + id + ", patient=" + patient + ", problems="
				+ problems + ", symptoms=" + symptoms + ", allergies="
				+ allergies + ", testResults=" + testResults + ", visitDt="
				+ visitDt + "]";
	}

}
