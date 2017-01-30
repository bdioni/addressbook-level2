package seedu.addressbook.data.person;

public class Unit {
	
	private String unit;
	
	public Unit(String value) {
		this.unit = value;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public String toString() {
		return this.getUnit();
	}

}
