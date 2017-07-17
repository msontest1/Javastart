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
			System.out.println("Maksymalna liczba ksi¹¿ek w bibliotece zosta³a osi¹gniêta.");
		}
	}
	
	public void addMagazine(Magazine magazine) {
		if (magazineNumber < MAX_MAGAZINES) {
			magazines[magazineNumber] = magazine;
			magazineNumber++;
		} else {
			System.out.println("Maksymalna liczba magazynów w bibliotece zosta³a osi¹gniêta.");
		}
	}
	
	public void printBooks() {
		if (bookNumber == 0) {
			System.out.println("Brak ksi¹¿ek w systemie.");
		} else {
			for(int i=0 ; i<bookNumber ; i++) {
				books[i].printInfo();
			}
		}
	}
	
	public void printMagazines() {
		if (magazineNumber == 0) {
			System.out.println("Brak magazynów w systemie.");
		} else {
			for(int i=0 ; i<magazineNumber ; i++) {
				magazines[i].printInfo();
			}
		}
	}
}