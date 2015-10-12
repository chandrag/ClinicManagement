package com.icare.beans;

import org.springframework.web.multipart.MultipartFile;

public class PatientBean {

	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private ContactBean contact;
	private int searchFor;
	private String searchText;
	private MultipartFile profilePic;
	private byte[] profileImageBytes;

	public PatientBean() {

	}

	public PatientBean(int id) {
		super();
		this.id = id;
	}

	public PatientBean(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public PatientBean(int id, String firstName, String middleName,
			String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ContactBean getContact() {
		return contact;
	}

	public void setContact(ContactBean contact) {
		this.contact = contact;
	}

	public int getSearchFor() {
		return searchFor;
	}

	public void setSearchFor(int searchFor) {
		this.searchFor = searchFor;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
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
		return "PatientBean [id=" + id + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName
				+ ", contact=" + contact + ", searchFor=" + searchFor
				+ ", searchText=" + searchText + ", profilePic=" + profilePic
				+ "]";
	}

}
