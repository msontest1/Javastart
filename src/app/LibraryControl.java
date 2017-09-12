package app;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import model.Book;
import model.Library;
import model.LibraryUser;
import model.Magazine;
import utils.DataReader;
import utils.FileManager;
import utils.LibraryUtils;

public class LibraryControl {
	private FileManager fileManager;
	private DataReader dataReader;
	
	private Library library;
	
	public LibraryControl() {
		dataReader = new DataReader();
		fileManager = new FileManager();
		try {
            library = fileManager.readLibraryFromFile();
            System.out.println("Wczytano dane biblioteki z pliku ");
        } catch (ClassNotFoundException | IOException e) {
            library = new Library();
            System.out.println("Utworzono now¹ bazê biblioteki.");
        }
	}
	
	public void controlLoop() {
		Option option = null;
        while (option != Option.EXIT) {
            try {
            	printMenu();
                option = Option.createFromInt(dataReader.getOption());
                switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case ADD_USER:
                    addUser();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case PRINT_USERS:
                    printUsers();
                    break;
                case EXIT:
                    exit();
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono niepoprawne dane, publikacji nie dodan.");
            } catch (NumberFormatException | NoSuchElementException e) {
            	System.out.println(e.getMessage());
                System.out.println("Wybrana opcja nie istnieje, wybierz ponownie:");
            }
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
	
	private void addUser() {
		LibraryUser user = dataReader.readAndCreateUser();
		library.addUser(user);
	}
	
	private void printBooks() {
		LibraryUtils.printBooks(library);
	}
	
	private void printMagazines() {
		LibraryUtils.printMagazines(library);
	}
	
	private void printUsers() {
		LibraryUtils.printUsers(library);
	}
	
	private void printMenu() {
		System.out.println("MENU:");
		for (Option o : Option.values()) {
			System.out.println(o);
		}
	}
	
	private void exit() {
        fileManager.writeLibraryToFile(library);
    }
	
	private enum Option {
		EXIT(0 ,"Wyjœcie z programu"),
		ADD_BOOK(1 , "Dodaj ksi¹¿ke"),
		ADD_MAGAZINE(2 , "Dodaj magazyn"),
		ADD_USER(3 , "Dodaj u¿ytkownika"),
		PRINT_BOOKS(4 , "Poka¿ ksi¹¿ki"),
		PRINT_MAGAZINES(5 , "Poka¿ magazyny"),
		PRINT_USERS(6 , "Poka¿ u¿ytkowników");
		
		private int value;
		private String description;
		
		Option(int value, String description) {
			this.value = value;
			this.description = description;
		}
		
		public static Option createFromInt(int option) throws NoSuchElementException {
			Option result = null;
			try {
				result = Option.values()[option];
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new NoSuchElementException("Brak elementu o wskazanym ID.");
			}
				
			return result;
		}
		
		@Override
		public String toString() {
			return value + " - " + description;
		}
	}
}
