package com.example.applicant;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Application implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String name;
	private String description;
	private String languagesknown;
	private String phonenumber;

	public Application() {

	}

	public Application(String id, String name, String description, String languagesKnown, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.languagesknown = languagesKnown;
		this.phonenumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phonenumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phonenumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguagesKnown() {
		return languagesknown;
	}

	public void setLanguagesKnown(String languagesKnown) {
		this.languagesknown = languagesKnown;
	}

}
