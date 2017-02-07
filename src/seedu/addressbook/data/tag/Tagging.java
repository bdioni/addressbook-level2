package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represents one instance tag addition or deletion for the corresponding person in the address book
 * @author brea
 *
 */
public class Tagging {
	
	public static enum TagType {
		ADD, DELETE
	}
	
	private Tag tag;
	private Person person;
	private TagType tagType;
	
	public Tagging(Person person, Tag tag, TagType tagType) {
		this.person = person;
		this.tag = tag;
		this.tagType = tagType;
	}
	
	@Override
	public String toString() {
		return (tagType == TagType.ADD ? "+ " : "- " ) 
				+ person.getName() + tag.toString();
	}

}
