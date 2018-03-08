package com.exam.apirest.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idContact;
	@NotNull
	private String name;
	private String company;
	private String profileImage;
	@NotNull
	private String email;
	private Date birthDate;
	private String phoneNumberWork;
	private String phoneNumberPersonal;
	@Embedded
	private Address address;

	public Integer getIdContact() {
		return idContact;
	}

	public void setIdContact(Integer idContact) {
		this.idContact = idContact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumberWork() {
		return phoneNumberWork;
	}

	public void setPhoneNumberWork(String phoneNumberWork) {
		this.phoneNumberWork = phoneNumberWork;
	}

	public String getPhoneNumberPersonal() {
		return phoneNumberPersonal;
	}

	public void setPhoneNumberPersonal(String phoneNumberPersonal) {
		this.phoneNumberPersonal = phoneNumberPersonal;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
