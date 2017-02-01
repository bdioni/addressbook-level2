package seedu.addressbook.data.exception;

import java.io.FileNotFoundException;

/**
 * Signals an error caused by duplicate data where there should be none.
 */
public class FileDeletedException extends Exception {
	
	private String message = "File was deleted while program was running";
	
	public String getMessage() {
		return message;
	}
	
}

