package utils;

import java.util.Scanner;

import model.Book;
import model.Magazine;

public class DataReader {
	private Scanner input;
	
	public DataReader() {
		input = new Scanner(System.in);
	}
	
	public void close() {
		input.close();
	}
	public int getOption() {
		int option = input.nextInt();
		input.nextLine();
		return option;
	}
	
	public Book readAndCreateBook() {
		System.out.println("Tytu�: ");
        String title = input.nextLine();
        System.out.println("Autor: ");
        String author = input.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = input.nextLine();
        System.out.println("ISBN: ");
        String isbn = input.nextLine();
        System.out.println("Rok wydania: ");
        int releaseDate = input.nextInt();
        input.nextLine();
        System.out.println("Ilo�� stron: ");
        int pages = input.nextInt();
        input.nextLine();
        
		return new Book(title, author, releaseDate, pages, publisher, isbn);
	}
	
	public Magazine readAndCreateMagazine() {
        System.out.println("Tytu�: ");
        String title = input.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = input.nextLine();
        System.out.println("J�zyk: ");
        String language = input.nextLine();
        System.out.println("Rok wydania: ");
        int year = input.nextInt();
        input.nextLine();
        System.out.println("Miesi�c: ");
        int month = input.nextInt();
        input.nextLine();
        System.out.println("Dzie�: ");
        int day = input.nextInt();
        input.nextLine();
         
        return new Magazine(title, publisher, language, year, month, day);
    }
}
