package com.learningSpring;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;

import io.swagger.annotations.Api;

@Embeddable
public class CustomerContact {

	private int phoneNr;
	@Email
	private String email;
	private String address;
	private int postCode;

	public CustomerContact(int phoneNr, String email, String address, int postCode) {

		this.phoneNr = phoneNr;
		this.email = email;
		this.address = address;
		this.postCode = postCode;
	}

	public CustomerContact() {

	}

	public int getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(int phoneNr) {
		this.phoneNr = phoneNr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	@Override
	public String toString() {
		return "CustomerContact [phoneNr=" + phoneNr + ", email=" + email + ", address=" + address + ", postCode="
				+ postCode + "]";
	}

}
