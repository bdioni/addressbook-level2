package seedu.addressbook.data.person;

import java.util.StringTokenizer;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public Block block;
    public Street street;
    public Unit unit;
    public PostalCode postalCode;
    
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        StringTokenizer stringSplitter = new StringTokenizer(trimmedAddress, ",");
        if (stringSplitter.hasMoreTokens()) {
        	block = new Block(stringSplitter.nextToken().trim());
        }
        if (stringSplitter.hasMoreTokens()) {
        	street = new Street(stringSplitter.nextToken().trim());
        }
        if (stringSplitter.hasMoreTokens()) {
        	unit = new Unit(stringSplitter.nextToken().trim());
        }
        if (stringSplitter.hasMoreTokens()) {
        	postalCode = new PostalCode(stringSplitter.nextToken().trim());	
        }
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {    	
    	
    	String temp = "";
    	
    	if (block != null) {
    		temp += block.toString();
    	}
    	
    	if (street != null) {
    		temp += ", ";
    		temp += street.toString();    		
    	}
    	
    	if (unit != null) {
    		temp += ", ";
    		temp += unit.toString();    		
    	}
    	
    	if (postalCode != null) {
    		temp += ", ";
    		temp += postalCode.toString();    		
    	}
    	
        return temp;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
