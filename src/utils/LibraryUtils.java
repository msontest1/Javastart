package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Book;
import model.Library;
import model.LibraryUser;
import model.Magazine;
import model.Publication;

public class LibraryUtils {
	private static void printPublications(Library library, Class cl) {
		long countPublication = library.getPublications().values().stream()
				.filter(cl::isInstance)
				.sorted(new Library.AlphabeticalComparator())
				.peek(System.out::println).count();
		if (countPublication==0) {
			System.out.println("Brak publikacji w systemie typu " + cl.getSimpleName());
		}
	}
	
	public static void printBooks(Library library) {	
		printPublications(library, Book.class);
	}
	
	public static void printMagazines(Library library) {
		printPublications(library, Magazine.class);
	}
	
	public static void printUsers(Library library) {
		List<LibraryUser> users = new ArrayList<>();
		users.addAll(library.getUsers().values());
		Collections.sort(users, new Comparator<LibraryUser>() {

			@Override
			public int compare(LibraryUser o1, LibraryUser o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
					
		});
		for (LibraryUser u: users) {
			System.out.println(u);
		}
	}
}
