package sait.bms.problemdoamin;

public class Cookbook extends Book {

	private String publisher;
	private String diet;
	private final String dietD = "Diabetic";
	private final String dietV = "Vegetarian";
	private final String dietG = "Gluten-free";
	private final String dietI = "International";
	private final String dietN = "None";

	public Cookbook() {
		super();
		// TODO Autogenerated constructor stub
	}

	public Cookbook(String isbn, String callNumber, int available, int total, String title, String publisher,
			String diet) {
		super(isbn, callNumber, available, total, title);
		this.publisher = publisher;
		this.diet = diet;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	@Override
	public String toString() {
		switch (getDiet()) {
		case "D": {
			diet = dietD;
			break;
		}
		case "V": {
			diet = dietV;
			break;
		}
		case "G": {
			diet = dietG;
			break;
		}
		case "I": {
			diet = dietI;
			break;
		}
		case "N": {
			diet = dietN;
			break;
		}
		}
		return String.format("%-18s%s\n%-18s%s\n%-18s%s\n%-18s%s\n%-18s%s\n%-18s%s\n%-18s%s\n", "ISBN:", getIsbn(),
				"Call Number:", getCallNumber(), "Available:", Integer.toString(getAvailable()), "Total:",
				Integer.toString(getTotal()), "Title:", getTitle(), "Publisher:", getPublisher(), "Diet:", diet);
	}
}
