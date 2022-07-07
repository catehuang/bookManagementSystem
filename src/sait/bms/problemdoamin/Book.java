package sait.bms.problemdoamin;

public class Book {
	private String isbn;
	private String callNumber;
	private int available;
	private int total;
	private String title;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String isbn, String callNumber, int available, int total, String title) {
		super();
		this.isbn = isbn;
		this.callNumber = callNumber;
		this.available = available;
		this.total = total;
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Create specific format for print out
	 */
	@Override
	public String toString() {
		return String.format("%-18s%s\n%-18s%s\n%-18s%s\n%-18s%s\n%-18s%s\n", 
				"ISBN:", getIsbn(), 
				"Call Number:", getCallNumber(), 
				"Available:", Integer.toString(getAvailable()), 
				"Total:", Integer.toString(getTotal()), 
				"Title:", getTitle());
	}

}
