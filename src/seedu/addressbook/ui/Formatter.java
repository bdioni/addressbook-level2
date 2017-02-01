package seedu.addressbook.ui;

import java.util.List;

/**
 * Formats text to be displayed by the text UI accdg to message type
 * @author brea
 *
 */
public class Formatter {

	public enum MessageType {
		WELCOME, GOODBYE, INIT_FAILED, FEEDBACK, PROMPT, OTHER		
	}

	/** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /**
     * Decorates lines according to the type of message
     * @param type one of values of type Formatter.MessageType
     * @param toDecorate Strings to be decorated (varargs)
     * @return formatted string to be printed directly
     */
	public static String decorate(MessageType type, String... toDecorate) {
		
		if (type != MessageType.PROMPT) {
			addPrefixAndSeparator(toDecorate);		
		}	
		
		StringBuilder decoratedString = new StringBuilder();

		if (type == MessageType.WELCOME) {

			decoratedString.append(addPrefixAndSeparator(DIVIDER) + LS);
			decoratedString.append(addPrefixAndSeparator(DIVIDER) + LS);
			
			for (String line: toDecorate) {
				decoratedString.append(line + LS);
			}
			
			decoratedString.append(addPrefixAndSeparator(DIVIDER) + LS);

		} else if (type == MessageType.GOODBYE
			|| type == MessageType.INIT_FAILED) {

			for (String line: toDecorate) {
				decoratedString.append(line + LS);
			}
			
			decoratedString.append(addPrefixAndSeparator(DIVIDER) + LS);
			decoratedString.append(addPrefixAndSeparator(DIVIDER) + LS);

		} else if (type == MessageType.FEEDBACK) {

			for (String line: toDecorate) {
				decoratedString.append(line + LS);
			}

			decoratedString.append(addPrefixAndSeparator(DIVIDER) + LS);

		} else if (type == MessageType.PROMPT) {

			for (String line: toDecorate) {
				decoratedString.append(LINE_PREFIX + line);
			}
			
		} else if (type == MessageType.OTHER) {
			
			for (String line: toDecorate) {
				decoratedString.append(line + LS);
			}
			
		}

		return decoratedString.toString();

	}

	/**
	 * Decorates lists
	 * @param listItems list of people
	 * @return formatted string to be printed directly
	 */
	public static String decorateIndexedList(List<String> listItems) {
		final StringBuilder decoratedString = new StringBuilder();
		int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
		for (String listItem: listItems) {
			decoratedString.append(getIndexedListItem(displayIndex, listItem)).append("\n");
			displayIndex++;
		}

		return addPrefixAndSeparator(decoratedString.toString()) + LS;
	}

	/**
	 * Adds prefix and separator (if appropriate); string array version
	 * @param toDecorate
	 * @return formatted string to be printed directly
	 */
	private static String[] addPrefixAndSeparator(String[] toDecorate) {
		for (int i = 0; i < toDecorate.length; i++) {
			toDecorate[i] = LINE_PREFIX + toDecorate[i].replace("\n", LS + LINE_PREFIX);
		}
		return toDecorate;
	}
	
	/**
	 * Adds prefix and separator (if appropriate); string version
	 * @param toDecorate
	 * @return formatted string to be printed directly
	 */
	private static String addPrefixAndSeparator(String toDecorate) {
		return LINE_PREFIX + toDecorate.replace("\n", LS + LINE_PREFIX);
	}

	/**
	 * Decorates each list item
	 * @param visibleIndex
	 * @param listItem
	 * @return formatted String for the given list item
	 */
	private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
