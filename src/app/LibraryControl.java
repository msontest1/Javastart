package app;

import model.Book;
import model.Library;
import model.Magazine;
import utils.DataReader;

public class LibraryControl {
	private final static int EXIT = 0;
	private final static int ADD_BOOK = 1;
	private final static int ADD_MAGAZINE = 2;
	private final static int PRINT_BOOKS = 3;
	private final static int PRINT_MAGAZINS = 4;
	
	private Library library;
	private DataReader dataReader;
	
	public LibraryControl() {
		library = new Library();
		dataReader = new DataReader();
	}
	
	public void controlLoop() {
		int option = -1;
		
		printMenu();
		while ((option = dataReader.getOption()) != EXIT) {
			
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
			default:
				System.out.println("Nie ma takiej opcji.");
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
		System.out.println("Menu:");
		System.out.println("0 - Wyjdz z programu");
		System.out.println("1 - Dodaj ksi¹¿kê");
		System.out.println("2 - Dodaj magazyn");
		System.out.println("3 - Pokaz ksiazki");
		System.out.println("41 - Pokaz magazyny");
	}
}
