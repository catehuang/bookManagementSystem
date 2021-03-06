package sait.bms.problemdoamin;

public class ChildrensBook extends Book {

	private String author;
	private String format;
	private final String formatP = "Picture book";
	private final String formatE = "Early Readers";
	private final String formatC = "Chapter book";

	public ChildrensBook() {
		super();
		// TODO Autogenerated constructor stub
	}

	public ChildrensBook(String isbn, String callNumber, int available, int total, String title, String author,
			String format) {
		super(isbn, callNumber, available, total, title);
		this.author = author;
		this.format = format;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * Convert abbreviation letters into words 
	 */
	@Override
	public String toString() {
		switch (getFormat()) {
		case "P": {
			format = formatP;
			break;
		}
		case "E": {
			format = formatE;
			break;
		}
		case "C": {
			format = formatC;
			break;
		}
		}

		return String.format("%-18s%s\n%-18s%s\n%-18s%s\n%-18s%s\n%-18s%s\n%-18s%s\n%-18s%s\n", "ISBN:", getIsbn(),
				"Call Number:", getCallNumber(), "Available:", Integer.toString(getAvailable()), "Total:",
				Integer.toString(getTotal()), "Title:", getTitle(), "Author:", getAuthor(), "Format:", format);
	}

}
