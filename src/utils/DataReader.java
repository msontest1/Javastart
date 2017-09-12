package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Book;
import model.LibraryUser;
import model.Magazine;
import model.User;

public class DataReader {
	private Scanner input;
	
	public DataReader() {
		input = new Scanner(System.in);
	}
	
	public void close() {
		input.close();
	}
	public int getOption() throws NumberFormatException {
		int number = 0;
        try {
            number = input.nextInt();
        } catch (InputMismatchException e) {
            throw new NumberFormatException("Liczba wprowadzona w niepoprawnej formie");
        } finally {
        	input.nextLine();
        }
        return number;
	}
	
	public Book readAndCreateBook() throws InputMismatchException{
		System.out.println("Tytu³: ");
        String title = input.nextLine();
        System.out.println("Autor: ");
        String author = input.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = input.nextLine();
        System.out.println("ISBN: ");
        String isbn = input.nextLine();
        System.out.println("Rok wydania: ");
        int releaseDate = 0;
        int pages = 0;
        try {
            releaseDate = input.nextInt();
            input.nextLine();
            System.out.println("Iloœæ stron: ");
            pages = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
        	input.nextLine();
            throw e;
        }
        
		return new Book(title, author, releaseDate, pages, publisher, isbn);
	}
	
	public Magazine readAndCreateMagazine() throws InputMismatchException{
        System.out.println("Tytu³: ");
        String title = input.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = input.nextLine();
        System.out.println("Jêzyk: ");
        String language = input.nextLine();
        System.out.println("Rok wydania: ");
        int year = 0;
        int month = 0;
        int day = 0;
        try {
            year = input.nextInt();
            input.nextLine();
            System.out.println("Miesi¹c: ");
            month = input.nextInt();
            input.nextLine();
            System.out.println("Dzieñ: ");
            day = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
        	input.nextLine();
            throw e;
        }
         
        return new Magazine(title, publisher, language, year, month, day);
    }
	
	public LibraryUser readAndCreateUser() throws InputMismatchException{
		System.out.println("Imie: ");
        String name = input.nextLine();
        System.out.println("Nazwisko: ");
        String surname = input.nextLine();
        System.out.println("PESEL: ");
        String pesel = input.nextLine();
		return new LibraryUser(name, surname, pesel);
	}
}
