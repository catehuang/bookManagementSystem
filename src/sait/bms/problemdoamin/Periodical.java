package sait.bms.problemdoamin;

public class Periodical extends Book {

	private String frequency;
	private final String frequencyD = "Daily";
	private final String frequencyW = "Weekly";
	private final String frequencyM = "Monthly";
	private final String frequencyB = "Bi-monthly";
	private final String frequencyQ = "Quarterly";

	public Periodical() {
		super();
	}

	public Periodical(String isbn, String callNumber, int available, int total, String title, String frequency) {
		super(isbn, callNumber, available, total, title);
		this.frequency = frequency;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	/**
	 * Convert abbreviation letters into words 
	 */
	@Override
	public String toString() {
		switch (getFrequency()) {
		case "D": {
			frequency = frequencyD;
			break;
		}
		case "W": {
			frequency = frequencyW;
			break;
		}
		case "M": {
			frequency = frequencyM;
			break;
		}
		case "B": {
			frequency = frequencyB;
			break;
		}
		case "Q": {
			frequency = frequencyQ;
			break;
		}
		}

		return String.format("%-18s%s\n%-18s%s\n%-18s%s\n%-18s%s\n%-18s%s\n%-18s%s\n", "ISBN:", getIsbn(),
				"Call Number:", getCallNumber(), "Available:", Integer.toString(getAvailable()), "Total:",
				Integer.toString(getTotal()), "Title:", getTitle(), "Frequency:", frequency);
	}

}
