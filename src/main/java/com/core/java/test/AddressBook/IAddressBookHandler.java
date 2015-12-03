package com.core.java.test.AddressBook;

import java.util.List;

import com.core.java.test.model.Gender;
import com.core.java.test.model.PersonRecord;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;

public interface IAddressBookHandler {

	List<PersonRecord> getSortedPersonRecordsByAge();
	
	PersonRecord getPersonRecordByName(String name);
	
	List<PersonRecord> getPersonRecordsFromCSV(CsvToBean<PersonRecord> csv, CSVReader csvReader);
	
	List<PersonRecord> getAllPersonRecordsByGender(Gender sex);
	
	int getDifferenceInDateOfBirths(PersonRecord a, PersonRecord b);
		

}
