package sait.bms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sait.bms.problemdoamin.*;

public class BookManager {
	private ArrayList<Book> books;
	private Scanner in;
	private final String FILE_PATH = "res/books.txt";
	private final String SAVE_TO = "res/books.txt";

	public BookManager() throws IOException {
		books = new ArrayList<>();
		loadBooks();
		displayMenu();
	}

	/**
	 * Perform display menu function
	 * 
	 * @throws IOException Thrown when the file could not be found or can not be written.
	 *                     
	 */
	private void displayMenu() throws IOException {
		int choice = 0;
		while (choice != 5) {
			System.out.println("Welcome in ABC Book Company: How May We Assist You?");
			System.out.println("1\tCheckout Book");
			System.out.println("2\tFind Books by Title");
			System.out.println("3\tDisplay Books by Type");
			System.out.println("4\tProduce Random Book List");
			System.out.println("5\tSave & Exit");
			System.out.println();
			System.out.printf("Enter option: ");
			in = new Scanner(System.in);

			if (in.hasNextInt()) {
				choice = in.nextInt();
				in.nextLine();

				switch (choice) {
				case 1: {
					checkoutBook();
					break;
				}
				case 2: {
					findBooksByTitile();
					break;
				}
				case 3: {
					displayBooksByType();
					break;
				}
				case 4: {
					produceRandomBookList();
					break;
				}
				case 5: {
					saveBook();
					break;
				}
				default: {
					System.out.println("Invalid input. Please try again.");
					System.out.println();
					break;
				}
				}
			} else {
				System.out.println("Invalid input. Please try again.");
				System.out.println();
			}
		}
	}

	/**
	 * Save data into file
	 * 
	 * @throws IOException Thrown when the file could not be written.
	 */
	private void saveBook() throws IOException {
		System.out.println("Save books and exit.");
		PrintWriter out = new PrintWriter(new FileWriter(SAVE_TO));

		for (Book b : books) {
			if (b instanceof ChildrensBook) {
				// ChildrensBook(isbn, callNumber, available, total, title, author, format)
				out.println(b.getIsbn() + ';' + b.getCallNumber() + ';' + b.getAvailable() + ';' + b.getTotal() + ';'
						+ b.getTitle() + ';' + ((ChildrensBook) b).getAuthor() + ';' + ((ChildrensBook) b).getFormat());
			} else if (b instanceof Cookbook) {
				// Cookbook(isbn, callNumber, available, total, title, publisher, diet)
				out.println(b.getIsbn() + ';' + b.getCallNumber() + ';' + b.getAvailable() + ';' + b.getTotal() + ';'
						+ b.getTitle() + ';' + ((Cookbook) b).getPublisher() + ';' + ((Cookbook) b).getDiet());
			} else if (b instanceof Paperback) {
				// Paperback(isbn, callNumber, available, total, title, author, year, genre)
				out.println(b.getIsbn() + ';' + b.getCallNumber() + ';' + b.getAvailable() + ';' + b.getTotal() + ';'
						+ b.getTitle() + ';' + ((Paperback) b).getAuthor() + ';' + ((Paperback) b).getYear() + ';'
						+ ((Paperback) b).getGenre());
			} else if (b instanceof Periodical) {
				// Periodical(isbn, callNumber, available, total, title, freq)
				out.println(b.getIsbn() + ';' + b.getCallNumber() + ';' + b.getAvailable() + ';' + b.getTotal() + ';'
						+ b.getTitle() + ';' + ((Periodical) b).getFrequency());
			} else {
				// Book(isbn, callNumber, available, total, title)
				out.println(b.getIsbn() + ';' + b.getCallNumber() + ';' + b.getAvailable() + ';' + b.getTotal() + ';'
						+ b.getTitle());
			}
		}
		out.close();
	}

	/**
	 * Performs "produce random book list" function
	 */
	private void produceRandomBookList() {
		System.out.printf("Enter number of books: ");
		if (in.hasNextInt()) {
			int numberOfBooks = in.nextInt();
			in.nextLine();
			Collections.shuffle(books);
			System.out.println("Random books:");
			for (int i = 0; i < numberOfBooks; i++) {
				System.out.println(books.get(i));
			}
		} else {
			System.out.println("Invalid input. Please try again.");
			System.out.println();
		}
	}

	/**
	 * Performs "display books by type" function
	 */
	private void displayBooksByType() {
		System.out.println("#\tType");
		System.out.println("1\tChildren's Books");
		System.out.println("2\tCookbooks");
		System.out.println("3\tPaperbacks");
		System.out.println("4\tPeriodicals");
		System.out.println();
		System.out.printf("Enter type of book: ");

		if (in.hasNextInt()) {
			int ChoiceTypeOfBook = in.nextInt();
			in.nextLine();

			switch (ChoiceTypeOfBook) {
			case 1: {
				System.out.printf("Enter a format (P for Picture book, E for Early Readers, or C Chapter book): ");
				String format = in.nextLine().toUpperCase();
				System.out.println("\nMatching books:");
				for (Book b : books) {
					if (b instanceof ChildrensBook) {
						if (((ChildrensBook) b).getFormat().equals(format)) {
							System.out.println((ChildrensBook) b);
						}
					}
				}
				break;
			}
			case 2: {
				System.out.printf(
						"Enter a diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None): ");
				String diet = in.nextLine().toUpperCase();
				System.out.println("\nMatching books:");
				for (Book b : books) {
					if (b instanceof Cookbook) {
						if (((Cookbook) b).getDiet().equals(diet)) {
							System.out.println((Cookbook) b);
						}
					}
				}
				break;
			}
			case 3: {
				System.out.printf(
						"Enter a genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction): ");
				String genre = in.nextLine().toUpperCase();
				System.out.println("\nMatching books:");
				for (Book b : books) {
					if (b instanceof Paperback) {
						if (((Paperback) b).getGenre().equals(genre)) {
							System.out.println((Paperback) b);
						}
					}
				}
				break;
			}
			case 4: {
				System.out.printf(
						"Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Bi-monthly, or Q for Quarterly): ");
				String frequency = in.nextLine().toUpperCase();
				System.out.println("\nMatching books:");
				for (Book b : books) {
					if (b instanceof Periodical) {
						if (((Periodical) b).getFrequency().equals(frequency)) {
							System.out.println((Periodical) b);
						}
					}
				}
				break;
			}
			default: {
				System.out.println("Invalid input. Please try again.");
				System.out.println();
				break;
			}
			}
		} else {
			System.out.println("Invalid input. Please try again.");
			System.out.println();
		}
	}

	/**
	 * Performs "find book by title" function
	 */
	private void findBooksByTitile() {
		System.out.printf("Enter title to search for: ");
		String title = in.nextLine();
		System.out.println("Matching books:");
		int matches = 0;

		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {
				matches++;
				System.out.println(books.get(i));
			}
		}
		if (matches == 0) {
			System.out.printf("The title %s didn't match any books.", title);
		}

	}

	/**
	 * Performs check out function
	 */
	private void checkoutBook() {
		System.out.printf("Enter ISBN of book: ");
		String isbn = in.nextLine();

		for (int i = 0; i < books.size(); i++) {
			int lastDight = (int) (Long.parseLong(books.get(i).getIsbn()) % 10);
			if (books.get(i).getIsbn().equals(isbn)) {
				int available = books.get(i).getAvailable();
				if (lastDight == 8 || lastDight == 9) {
					System.out.printf("\nThe book \"%s\" cannot be checked out because it is a periodical.\n",
							books.get(i).getTitle());
					System.out.printf("It can be located using a call number: %s\n\n", books.get(i).getCallNumber());
					return;
				} else if (available > 0) {
					books.get(i).setAvailable(available - 1);
					/* A periodical cannot be checked out. */
					System.out.printf("\nThe book \"%s\" has been checked out.\n", books.get(i).getTitle());
					System.out.printf("It can be located using a call number: %s\n\n", books.get(i).getCallNumber());
					return;
				} else {
					System.out.printf("\nThe book %s is not available.\n\n", books.get(i).getTitle());
					return;
				}
			}
		} 
		System.out.printf("Entered ISBN %s did not match any books.\n\n", isbn);
	}

	/**
	 * Read data from file
	 * 
	 * @throws FileNotFoundException Thrown when the file could not be found.
	 */
	private void loadBooks() throws FileNotFoundException {
		Scanner in = new Scanner(new File(FILE_PATH));

		while (in.hasNext()) {
			String[] fields = in.nextLine().split(";");

			String isbn = fields[0];
			String callNumber = fields[1];
			int available = Integer.parseInt(fields[2]);
			int total = Integer.parseInt(fields[3]);
			String title = fields[4];

			int lastDight = (int) (Long.parseLong(fields[0]) % 10);

			switch (lastDight) {
			case 0:
			case 1: {
				String author = fields[5];
				String format = fields[6];
				books.add(new ChildrensBook(isbn, callNumber, available, total, title, author, format));
				break;
			}
			case 2:
			case 3: {
				String publisher = fields[5];
				String diet = fields[6];
				books.add(new Cookbook(isbn, callNumber, available, total, title, publisher, diet));
				break;
			}
			case 4:
			case 7: {
				String author = fields[5];
				int year = Integer.parseInt(fields[6]);
				String genre = fields[7];
				books.add(new Paperback(isbn, callNumber, available, total, title, author, year, genre));
				break;
			}
			case 8:
			case 9: {
				String freq = fields[5];
				books.add(new Periodical(isbn, callNumber, available, total, title, freq));
				break;
			}
			default: {
				// how to deal with those books(5$, 6$) in the books.txt but they don't beString
				// to four kinds of books?
				// They are still in the list, so I still create object for them.
				books.add(new Book(isbn, callNumber, available, total, title));
				break;
			}
			}
		}
		in.close();
	}
}
