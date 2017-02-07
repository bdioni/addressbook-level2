package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents one of a person's contact info in the address book
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String, String)}
 * @author brea
 *
 */
public class Contact {
		
	public final String value;
	protected boolean isPrivate;
	
    /**
     * Validates given contact information using regex provided
     *
     * @throws IllegalValueException if given contact string is invalid
     */
	public Contact(String contact, boolean isPrivate, String validationRegex, String messageContactConstraint) throws IllegalValueException {
		this.isPrivate = isPrivate;
		String trimmedContact = contact.trim();
		if (!isValidContact(trimmedContact, validationRegex)) {
			throw new IllegalValueException(messageContactConstraint);
		}
		this.value = trimmedContact;
	}
	
    /**
     * Checks if a given contact string is in acceptable format
     */
	public static boolean isValidContact(String test, String validationRegex) {
		return test.matches(validationRegex);
	}
	
	@Override
	public String toString() {
		return this.value;		
	}
	
	@Override
	public boolean equals(Object other) {
		return (other == this)
				|| ((this.getClass()).isInstance(other))
				|| this.value.equals(((Contact) other).value);
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	public boolean isPrivate() {
		return isPrivate;
	}
	

}
