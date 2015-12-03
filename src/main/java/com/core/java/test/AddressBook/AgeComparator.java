package com.core.java.test.AddressBook;

import java.util.Comparator;
import org.joda.time.DateTime;
import com.core.java.test.model.PersonRecord;
/**
 * Comparator to sort PersonRecord By Age
 * 
 * @author KoushikM
 *
 */
public class AgeComparator implements Comparator<PersonRecord> {

	public int compare(PersonRecord o1, PersonRecord o2) {
		DateTime d1 = AddressBookHandler.DATE_FORMAT.parseDateTime(o1
				.getDateOfBirth().trim());
		DateTime d2 = AddressBookHandler.DATE_FORMAT.parseDateTime(o1
				.getDateOfBirth().trim());
		return d2.compareTo(d1) > 0 ? 1 : -1;
	}

}
