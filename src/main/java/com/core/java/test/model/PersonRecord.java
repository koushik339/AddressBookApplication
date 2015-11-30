package com.core.java.test.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonRecord {

	private String name;
	private Gender gender;
	private Date dateOfBirth;
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");

	public PersonRecord(String name, Gender gender, Date dateOfBirth) {
		super();
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "PersonRecord [name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
