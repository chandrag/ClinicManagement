package com.icare.entities;

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
@Table(name = "address", schema = "icare")
public class AddressEntity {

	@Id
	@Column(name = "contact_id")
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "contact"))
	private int id;
	private String addrLine1;
	private String addrLine2;
	private String city;
	private String state;
	private int pinCode;
	@OneToOne
	@PrimaryKeyJoinColumn
	private ContactEntity contact;

	public AddressEntity() {

	}

	public AddressEntity(int id, String addrLine1, String addrLine2,
			String city, String state, int pinCode) {
		super();
		this.id = id;
		this.addrLine1 = addrLine1;
		this.addrLine2 = addrLine2;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	public AddressEntity(String addrLine1, String addrLine2, String city,
			String state, int pinCode) {
		super();
		this.addrLine1 = addrLine1;
		this.addrLine2 = addrLine2;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public ContactEntity getContact() {
		return contact;
	}

	public void setContact(ContactEntity contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "AddressModel [id=" + id + ", addrLine1=" + addrLine1
				+ ", addrLine2=" + addrLine2 + ", city=" + city + ", state="
				+ state + ", pinCode=" + pinCode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addrLine1 == null) ? 0 : addrLine1.hashCode());
		result = prime * result
				+ ((addrLine2 == null) ? 0 : addrLine2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + id;
		result = prime * result + pinCode;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		AddressEntity other = (AddressEntity) obj;
		if (addrLine1 == null) {
			if (other.addrLine1 != null)
				return false;
		} else if (!addrLine1.equals(other.addrLine1))
			return false;
		if (addrLine2 == null) {
			if (other.addrLine2 != null)
				return false;
		} else if (!addrLine2.equals(other.addrLine2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (id != other.id)
			return false;
		if (pinCode != other.pinCode)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

}
