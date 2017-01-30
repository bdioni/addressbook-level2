package seedu.addressbook.data.person;

public class Street {
	
	private String street;
	
	public Street(String value) {
		this.street = value;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String toString() {
		return this.getStreet();
	}
	
}
