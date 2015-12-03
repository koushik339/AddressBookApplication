package com.core.java.test.model;

/**
 * Creates the Model Object for PersonRecord
 * 
 * @author KoushikM
 *
 */
public class PersonRecord {

	private String name;
	private Gender gender;
	private String dateOfBirth;

	/**
	 * Creates default constructor
	 */
	public PersonRecord() {
	}

	/**
	 * Constructor to initialise the PersonRecord
	 * 
	 * @param name
	 * @param gender
	 * @param dateOfBirth
	 */
	public PersonRecord(String name, Gender gender, String dateOfBirth) {
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "PersonRecord [name=" + name + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}

}
