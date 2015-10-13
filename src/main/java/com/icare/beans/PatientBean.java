package com.icare.beans;

import org.springframework.web.multipart.MultipartFile;

public class PatientBean {

	private int id;
	private int mrdNo;
	private String name;
	private int age;
	private String sex;
	private String address;
	private long contactNo;
	private String referredBy;
	private double fees;
	private double procedureFees;
	private MultipartFile profilePic;
	private byte[] profileImageBytes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMrdNo() {
		return mrdNo;
	}

	public void setMrdNo(int mrdNo) {
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

	public MultipartFile getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}

	public byte[] getProfileImageBytes() {
		return profileImageBytes;
	}

	public void setProfileImageBytes(byte[] profileImageBytes) {
		this.profileImageBytes = profileImageBytes;
	}

	@Override
	public String toString() {
		return "PatientBean [id=" + id + ", mrdNo=" + mrdNo + ", name=" + name
				+ ", age=" + age + ", sex=" + sex + ", address=" + address
				+ ", contactNo=" + contactNo + ", referredBy=" + referredBy
				+ ", fees=" + fees + ", procedureFees=" + procedureFees
				+ ", profilePic=" + profilePic + "]";
	}

}
