package com.core.java.test.AddressBook;

import java.io.FileNotFoundException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.core.java.test.model.Gender;

/**
 * Unit test for simple AddressBookHandler.
 */
public class AddressBookTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AddressBookTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AddressBookTest.class);
	}

	/**
	 * Tests the total number of Males in AddressBook
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTotalNumberOfMales() throws FileNotFoundException {
		IAddressBookHandler addBookHandler = new AddressBookHandler();
		assertEquals("The total number of males in the group is 3.",
				addBookHandler.getAllPersonRecordsByGender(Gender.Male).size(),
				3);
	}

	/**
	 * Tests the oldest person in the AddressBook
	 * 
	 * @throws FileNotFoundException
	 */
	public void testOldestPerson() throws FileNotFoundException {
		IAddressBookHandler addBookHandler = new AddressBookHandler();
		assertEquals("Wes Jackson", addBookHandler
				.getSortedPersonRecordsByAge().get(0).getName());
	}

	/**
	 * Tests the difference in Age between Paul and Bill
	 * 
	 * @throws FileNotFoundException
	 */
	public void testDifferenceOfAgePaulAndBillInDays()
			throws FileNotFoundException {
		IAddressBookHandler addBookHandler = new AddressBookHandler();
		assertEquals("Difference in Age between Paul and Bill is 2921 days::",
				addBookHandler.getDifferenceInDateOfBirths(
						addBookHandler.getPersonRecordByName("Bill McKnight"),
						addBookHandler.getPersonRecordByName("Paul Robinson")),
				2921);
	}
}
