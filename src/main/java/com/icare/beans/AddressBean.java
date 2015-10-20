package com.icare.beans;

public class AddressBean {

	private int id;
	private String addrLine1;
	private String addrLine2;
	private String city;
	private String state;
	private int pinCode;
	private ContactBean contact;

	public AddressBean() {

	}

	public AddressBean(String addrLine1, String addrLine2, String city,
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

	public ContactBean getContact() {
		return contact;
	}

	public void setContact(ContactBean contact) {
		this.contact = contact;
	}

}
// adding some test code at the end of the line
//Adding again
