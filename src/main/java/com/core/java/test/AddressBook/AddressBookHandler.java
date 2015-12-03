package com.core.java.test.AddressBook;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.core.java.test.model.Gender;
import com.core.java.test.model.PersonRecord;

/**
 * <h1>Address Book Handler</h1>
 * <p>
 * This program reads from a CSV file and creates a Address Book & allows Users
 * to query the Address Book
 * 
 * @author KoushikM
 * @version 1.0
 */
public class AddressBookHandler implements IAddressBookHandler {

	public static CsvToBean<PersonRecord> csv;
	public static CSVReader csvReader;
	public static List<PersonRecord> list;
	public static Map<String, PersonRecord> hmap = new HashMap<String, PersonRecord>();
	public static final DateTimeFormatter DATE_FORMAT = DateTimeFormat
			.forPattern("DD/MM/YY");

	/**
	 * Default Constructor of the AddressBook Initialises the AddressBook with
	 * records from the CSV
	 * 
	 * @throws FileNotFoundException
	 */
	public AddressBookHandler() throws FileNotFoundException {
		csv = new CsvToBean<PersonRecord>();
		String csvFilename = "src/main/resources/addressbook.csv";
		csvReader = new CSVReader(new FileReader(csvFilename));
	}

	/**
	 * Main method used to initialise Address Book.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		AddressBookHandler addrBookHandler;
		try {
			addrBookHandler = new AddressBookHandler();
			addrBookHandler.getPersonRecordsFromCSV(csv, csvReader);

			System.out.println("Difference in days between Paul and Bill ::"
					+ addrBookHandler.getDifferenceInDateOfBirths(
							addrBookHandler
									.getPersonRecordByName("Bill McKnight"),
							addrBookHandler
									.getPersonRecordByName("Paul Robinson")));

			System.out.println("The oldest person is::"
					+ addrBookHandler.getSortedPersonRecordsByAge().get(0));

			System.out.println("Total Number of Males in the group ::"
					+ addrBookHandler.getAllPersonRecordsByGender(Gender.Male)
							.size());

		} catch (FileNotFoundException e) {
			System.out
					.println("Problems while accessing the file. Please check the file location..");
			e.printStackTrace();
		}
	}

	/**
	 * Sorts the AddressBook in the chronological order of DOB
	 * 
	 * @return List<PersonRecord>
	 */
	public List<PersonRecord> getSortedPersonRecordsByAge() {
		if (list == null || (list != null && list.size() == 0))
			list = getPersonRecordsFromCSV(csv, csvReader);

		Collections.sort(list, new AgeComparator());
		return list;
	}

	/**
	 * Fetches all Person Records by Gender from the AddressBook
	 * 
	 * @param sex
	 *            Gender object
	 * @return List<PersonRecord>
	 */
	public List<PersonRecord> getAllPersonRecordsByGender(Gender sex) {
		List<PersonRecord> listGenders = new ArrayList<PersonRecord>();
		if (list == null || (list != null && list.size() == 0))
			list = getPersonRecordsFromCSV(csv, csvReader);

		for (PersonRecord personRecord : list) {
			if ((personRecord.getGender().toString().trim()).equals(sex
					.toString())) {
				listGenders.add(personRecord);
			}
		}

		return listGenders;
	}

	/**
	 * Fetches the difference in dates between 2 Persons
	 * 
	 * @param a PersonRecord
	 * @param b PersonRecord            
	 * @return int
	 */
	public int getDifferenceInDateOfBirths(PersonRecord a, PersonRecord b) {
		return Days.daysBetween(
				DATE_FORMAT.parseDateTime(a.getDateOfBirth().trim()),
				DATE_FORMAT.parseDateTime(b.getDateOfBirth().trim())).getDays();
	}

	/**
	 * Fetches Persons from the CSV supplied. Creates a List of PersonRecord
	 * object
	 * 
	 * @param csv CsvBean
	 *            <PesonRecord>
	 * @param csvReader CsvReader
	 * @return List<PersonRecord>
	 */
	public List<PersonRecord> getPersonRecordsFromCSV(
			CsvToBean<PersonRecord> csv, CSVReader csvReader) {
		list = csv.parse(setColumnMapping(), csvReader);

		for (Object object : list) {
			PersonRecord addressbook = (PersonRecord) object;
			hmap.put(addressbook.getName(), addressbook);
		}
		return list;
	}

	private static ColumnPositionMappingStrategy<PersonRecord> setColumnMapping() {
		ColumnPositionMappingStrategy<PersonRecord> strategy = 
				new ColumnPositionMappingStrategy<PersonRecord>();
		strategy.setType(PersonRecord.class);
		String[] columns = new String[] { "name", "gender", "dateOfBirth" };
		strategy.setColumnMapping(columns);
		return strategy;
	}

	/**
	 * Fetches a Person Record object by Name
	 * 
	 * @param String
	 *            name
	 * @return PersonRecord object
	 */
	public PersonRecord getPersonRecordByName(String name) {
		if (list == null || (list != null && list.size() == 0))
			list = getPersonRecordsFromCSV(csv, csvReader);

		return hmap.get(name);
	}

}
