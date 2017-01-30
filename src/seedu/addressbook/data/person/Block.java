package seedu.addressbook.data.person;

public class Block {
	
	private String block;
	
	public Block(String value) {
		this.block = value;
	}
	
	public String getBlock() {
		return block;
	}
	
	public String toString() {
		return this.getBlock();
	}

}
