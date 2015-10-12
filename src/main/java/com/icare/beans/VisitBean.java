package com.icare.beans;

import java.util.ArrayList;
import java.util.List;

public class VisitBean {

	private int id;
	private PatientBean patient;
	private String problems;
	private String symptoms;
	private String allergies;
	private String testResults;
	private String visitDt;
	private List<PrescriptionBean> prescriptions = new ArrayList<>();

	public VisitBean() {
	}

	public VisitBean(int id) {
		super();
		this.id = id;
	}

	public VisitBean(int id, PatientBean patient, String problems,
			String symptoms, String allergies, String testResults,
			String visitDt) {
		super();
		this.id = id;
		this.patient = patient;
		this.problems = problems;
		this.symptoms = symptoms;
		this.allergies = allergies;
		this.testResults = testResults;
		this.visitDt = visitDt;
	}

	public VisitBean(PatientBean patient, String problems, String symptoms,
			String allergies, String testResults, String visitDt) {
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

	public PatientBean getPatient() {
		return patient;
	}

	public void setPatient(PatientBean patient) {
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

	public String getVisitDt() {
		return visitDt;
	}

	public void setVisitDt(String visitDt) {
		this.visitDt = visitDt;
	}

	public List<PrescriptionBean> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<PrescriptionBean> prescriptions) {
		this.prescriptions = prescriptions;
	}

	@Override
	public String toString() {
		return "VisitBean [id=" + id + ", patient=" + patient + ", problems="
				+ problems + ", symptoms=" + symptoms + ", allergies="
				+ allergies + ", testResults=" + testResults + ", visitDt="
				+ visitDt + ", prescriptions=" + prescriptions + "]";
	}

}
