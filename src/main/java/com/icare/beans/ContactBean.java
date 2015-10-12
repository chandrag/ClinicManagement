package com.icare.beans;

public class ContactBean {

	private int id;
	private long mobileNo;
	private long landline;
	private String personalEmail;
	private String officialEmail;
	private AddressBean address;
	private PatientBean patient;

	public ContactBean() {

	}

	public ContactBean(long mobileNo, long landline, String personalEmail,
			String officialEmail) {
		super();
		this.mobileNo = mobileNo;
		this.landline = landline;
		this.personalEmail = personalEmail;
		this.officialEmail = officialEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getLandline() {
		return landline;
	}

	public void setLandline(long landline) {
		this.landline = landline;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getOfficialEmail() {
		return officialEmail;
	}

	public void setOfficialEmail(String officialEmail) {
		this.officialEmail = officialEmail;
	}

	public AddressBean getAddress() {
		return address;
	}

	public void setAddress(AddressBean address) {
		this.address = address;
	}

	public PatientBean getPatient() {
		return patient;
	}

	public void setPatient(PatientBean patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "ContactTO [id=" + id + ", mobileNo=" + mobileNo + ", landline="
				+ landline + ", personalEmail=" + personalEmail
				+ ", officialEmail=" + officialEmail + ", address=" + address
				+ "]";
	}

}
