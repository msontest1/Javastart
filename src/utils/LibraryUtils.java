package utils;

import java.util.Arrays;

import model.Book;
import model.Library;
import model.Magazine;
import model.Publication;

public class LibraryUtils {
	public static void printBooks(Library library) {
		Publication[] publications = library.getPublications();
		Arrays.sort(publications, new Library.AlphabeticalComparator());
		int publicationNumber = library.getPublicationNumber();
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
	
	public static void printMagazines(Library library) {
		Publication[] publications = library.getPublications();
		Arrays.sort(publications, new Library.AlphabeticalComparator());
		int publicationNumber = library.getPublicationNumber();
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
