package com.learningSpring;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Date createdAt;

	@Embedded
	@Valid
	private CustomerContact contact;

	public Customer(String name, CustomerContact contact) {

		this.name = name;
		this.createdAt = new Date();
		this.contact = contact;
	}

	public Customer() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public CustomerContact getContact() {
		return contact;
	}

	public void setContact(CustomerContact contact) {
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

}
