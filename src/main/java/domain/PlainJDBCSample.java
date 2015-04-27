package domain;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

public class PlainJDBCSample {
	private static final ContactDAO contactDao = new PlainContactDao();

	public static void main(String[] args) throws ParseException {
		System.out.println("Listing initial contact data:");
		listAllContacts();
		System.out.println("");
		Contact c = new Contact();
		c.setBirthDate(Date.valueOf("1989-11-04"));
		c.setFirstName("Pablo");
		c.setLastName("Chiljenno");
		contactDao.insert(c);
		System.out.println("List all contacts, after added new:");
		listAllContacts();
		System.out.println("");
		System.out.println("Deleting the previous creating contact:");
		contactDao.delete(c);
		System.out.println("Listening all contact data after new contact deleted");
		listAllContacts();

	}

	private static void listAllContacts() {
		List<Contact> cs = contactDao.findAll();
		for (Contact c : cs) {
			System.out.println("Contact:" + c);
		}
	}
}
