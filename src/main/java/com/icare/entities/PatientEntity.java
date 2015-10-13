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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + (int) (contactNo ^ (contactNo >>> 32));
		long temp;
		temp = Double.doubleToLongBits(fees);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((mrdNo == null) ? 0 : mrdNo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(procedureFees);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((referredBy == null) ? 0 : referredBy.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
		PatientEntity other = (PatientEntity) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (contactNo != other.contactNo)
			return false;
		if (Double.doubleToLongBits(fees) != Double
				.doubleToLongBits(other.fees))
			return false;
		if (id != other.id)
			return false;
		if (mrdNo == null) {
			if (other.mrdNo != null)
				return false;
		} else if (!mrdNo.equals(other.mrdNo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(procedureFees) != Double
				.doubleToLongBits(other.procedureFees))
			return false;
		if (referredBy == null) {
			if (other.referredBy != null)
				return false;
		} else if (!referredBy.equals(other.referredBy))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PatientEntity [id=" + id + ", mrdNo=" + mrdNo + ", name="
				+ name + ", age=" + age + ", sex=" + sex + ", address="
				+ address + ", contactNo=" + contactNo + ", referredBy="
				+ referredBy + ", fees=" + fees + ", procedureFees="
				+ procedureFees + "]";
	}

}
