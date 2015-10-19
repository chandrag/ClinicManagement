package com.icare.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient", schema = "icare")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Integer mrdNo;
	private String name;
	private int age;
	private String sex;
	private String address;
	private long contactNo;
	private String referredBy;
	private double fees;
	private double procedureFees;
	private String diseaseHistory;
	private String allergies;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getMrdNo() {
		return mrdNo;
	}

	public void setMrdNo(Integer mrdNo) {
		this.mrdNo = mrdNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public double getProcedureFees() {
		return procedureFees;
	}

	public void setProcedureFees(double procedureFees) {
		this.procedureFees = procedureFees;
	}

	public String getDiseaseHistory() {
		return diseaseHistory;
	}

	public void setDiseaseHistory(String diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	@Override
	public String toString() {
		return "PatientEntity [id=" + id + ", mrdNo=" + mrdNo + ", name="
				+ name + ", age=" + age + ", sex=" + sex + ", address="
				+ address + ", contactNo=" + contactNo + ", referredBy="
				+ referredBy + ", fees=" + fees + ", procedureFees="
				+ procedureFees + ", diseaseHistory=" + diseaseHistory
				+ ", allergies=" + allergies + "]";
	}

}
