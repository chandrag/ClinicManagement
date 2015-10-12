package com.icare.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "contact", schema = "icare")
public class ContactEntity {

	@Id
	@Column(name = "patient_id")
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "patient"))
	private int id;
	@Column(name = "mobile_no")
	private long mobileNo;
	private long landline;
	@Column(name = "personal_email")
	private String personalEmail;
	@Column(name = "official_email")
	private String officialEmail;
	@OneToOne(mappedBy = "contact", cascade = CascadeType.ALL)
	private AddressEntity address;
	@OneToOne
	@PrimaryKeyJoinColumn
	private PatientEntity patient;

	public ContactEntity() {

	}

	public ContactEntity(int id, long mobileNo, long landline,
			String personalEmail, String officialEmail, AddressEntity address) {
		super();
		this.id = id;
		this.mobileNo = mobileNo;
		this.landline = landline;
		this.personalEmail = personalEmail;
		this.officialEmail = officialEmail;
		this.address = address;
	}

	public ContactEntity(long mobileNo, long landline, String personalEmail,
			String officialEmail) {
		super();
		this.mobileNo = mobileNo;
		this.landline = landline;
		this.personalEmail = personalEmail;
		this.officialEmail = officialEmail;
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

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "ContactModel [id=" + id + ", mobileNo=" + mobileNo
				+ ", landline=" + landline + ", personalEmail=" + personalEmail
				+ ", officialEmail=" + officialEmail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + (int) (landline ^ (landline >>> 32));
		result = prime * result + (int) (mobileNo ^ (mobileNo >>> 32));
		result = prime * result
				+ ((officialEmail == null) ? 0 : officialEmail.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		result = prime * result
				+ ((personalEmail == null) ? 0 : personalEmail.hashCode());
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
		ContactEntity other = (ContactEntity) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (landline != other.landline)
			return false;
		if (mobileNo != other.mobileNo)
			return false;
		if (officialEmail == null) {
			if (other.officialEmail != null)
				return false;
		} else if (!officialEmail.equals(other.officialEmail))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		if (personalEmail == null) {
			if (other.personalEmail != null)
				return false;
		} else if (!personalEmail.equals(other.personalEmail))
			return false;
		return true;
	}

}
