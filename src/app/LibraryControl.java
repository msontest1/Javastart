package app;

import model.Book;
import model.Library;
import model.Magazine;
import utils.DataReader;

public class LibraryControl {
	private Library library;
	private DataReader dataReader;
	
	public LibraryControl() {
		library = new Library();
		dataReader = new DataReader();
	}
	
	public void controlLoop() {
		Option option;
		
		printMenu();
		while ((option = Option.createFromInt(dataReader.getOption())) != Option.EXIT) {
			
			switch(option) {
			case ADD_BOOK:
				addBook();
				break;
			case PRINT_BOOKS:
				showBooks();
				break;
			case ADD_MAGAZINE:
				addMagazine();
				break;
			case PRINT_MAGAZINS:
				showMagazines();
				break;
			case EXIT:
				break;
			}
			printMenu();
		}
		System.out.println("Zamykam program.");
		dataReader.close();
	}
	
	private void addBook() {
		Book book = dataReader.readAndCreateBook();
		library.addBook(book);
	}
	
	private void addMagazine() {
		Magazine magazine = dataReader.readAndCreateMagazine();
		library.addMagazine(magazine);
	}
	
	private void showBooks() {
		library.printBooks();
	}
	
	private void showMagazines() {
		library.printMagazines();
	}
	
	private void printMenu() {
		System.out.println("MENU:");
		for (Option o : Option.values()) {
			System.out.println(o);
		}
	}
}
