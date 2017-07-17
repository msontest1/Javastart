package model;

public class Library {
	public static final int MAX_BOOKS = 1000;
	public static final int MAX_MAGAZINES = 1000;
	private Book[] books;
	private Magazine[] magazines;
	private int bookNumber;
	private int magazineNumber;
	
	public Library() {
		books = new Book[MAX_BOOKS];
		magazines = new Magazine[MAX_MAGAZINES];
	}

	public Book[] getBooks() {
		return books;
	}
	
	public Magazine[] getMagazines() {
		return magazines;
	}

	public int getBookNumber() {
		return bookNumber;
	}
	
	public int getMagazineNumber() {
		return magazineNumber;
	}
	
	public void addBook(Book book) {
		if (bookNumber < MAX_BOOKS) {
			books[bookNumber] = book;
			bookNumber++;
		} else {
			System.out.println("Maksymalna liczba ksi��ek w bibliotece zosta�a osi�gni�ta.");
		}
	}
	
	public void addMagazine(Magazine magazine) {
		if (magazineNumber < MAX_MAGAZINES) {
			magazines[magazineNumber] = magazine;
			magazineNumber++;
		} else {
			System.out.println("Maksymalna liczba magazyn�w w bibliotece zosta�a osi�gni�ta.");
		}
	}
	
	public void printBooks() {
		if (bookNumber == 0) {
			System.out.println("Brak ksi��ek w systemie.");
		} else {
			for(int i=0 ; i<bookNumber ; i++) {
				books[i].printInfo();
			}
		}
	}
	
	public void printMagazines() {
		if (magazineNumber == 0) {
			System.out.println("Brak magazyn�w w systemie.");
		} else {
			for(int i=0 ; i<magazineNumber ; i++) {
				magazines[i].printInfo();
			}
		}
	}
}