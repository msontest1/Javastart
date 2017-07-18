package model;

public class Library {
	public static final int MAX_BOOKS = 1000;
	public static final int MAX_MAGAZINES = 1000;
	public static final int MAX_PUBLICATIONS = 2000;
	private Publication[] publications;
	private int publicationNumber;
	
	public Library() {
		publications = new Publication[MAX_PUBLICATIONS];
	}
	
	
	public Publication[] getPublications() {
		return publications;
	}

	public int getPublicationNumber() {
		return publicationNumber;
	}

	public void addBook(Book book) {
		addPublication(book);
	}
	
	public void addMagazine(Magazine magazine) {
		addPublication(magazine);
	}
	
	private void addPublication(Publication publication) {
		if (publicationNumber < MAX_PUBLICATIONS) {
			publications[publicationNumber] = publication;
			publicationNumber++;
		} else {
			System.out.println("Maksymalna liczba publikacji w bibliotece zosta³a osi¹gniêta.");
		}
	}
	
	public void printBooks() {
		int countBooks = 0;
		if (publicationNumber == 0) {
			System.out.println("Brak publikacji w systemie.");
		} else {
			for(int i=0 ; i<publicationNumber ; i++) {
				if (publications[i] instanceof Book) {
					System.out.println(publications[i]);
					countBooks++;
				}
			}
			if (countBooks==0) {
				System.out.println("Brak ksi¹¿ek w systemie.");
			}
		}
	}
	
	public void printMagazines() {
		int countMagazines = 0;
		if (publicationNumber == 0) {
			System.out.println("Brak publikacji w systemie.");
		} else {
			for(int i=0 ; i<publicationNumber ; i++) {
				if (publications[i] instanceof Magazine) {
					System.out.println(publications[i]);
					countMagazines++;
				}
			}
			if (countMagazines==0) {
				System.out.println("Brak magazynów w systemie.");
			}
		}
	}
}