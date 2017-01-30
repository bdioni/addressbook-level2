package seedu.addressbook.data.person;

public class PostalCode {
	
	private String postalCode;
	
	public PostalCode(String value) {
		this.postalCode = value;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public String toString() {
		return this.getPostalCode();
	}

}
