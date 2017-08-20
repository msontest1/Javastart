package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

public class Library implements Serializable{
	private static final long serialVersionUID = 4860599209931072434L;
	
	public static final int INITIAL_CAPACITY = 1;
	private Publication[] publications;
	private int publicationNumber;
	
	public Library() {
		publications = new Publication[INITIAL_CAPACITY];
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
	
	public void removePublication(Publication pub) {
		if (pub == null) {
			return;
		}
		
		final int NOT_FOUND = -1;
		int found = NOT_FOUND;
		int i = 0;
		while ( i < publications.length && found == NOT_FOUND) {
			if (pub.equals(publications[i])) {
				found = i;
			} else {
				i++;
			}
		}
		
		if (found != NOT_FOUND) {
			System.arraycopy(publications, found + 1, publications, found, publications.length - found - 1);
		}
	}
	
	private void addPublication(Publication publication) {
		if (publicationNumber == publications.length) {
			publications = Arrays.copyOf(publications, publications.length * 2);
		}
		publications[publicationNumber] = publication;
		publicationNumber++;
	}

	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i < publicationNumber; i++) {
            builder.append(publications[i]);
            builder.append("\n");
        }
        return builder.toString();
    }
	
	public static class AlphabeticalComparator implements Comparator<Publication> {

		@Override
		public int compare(Publication arg0, Publication arg1) {
			if (arg0 == null && arg1 == null) {
				return 0;
			}
			if (arg0 == null) {
				return 1;
			}
			if (arg1 == null) {
				return -1;
			}
			return arg0.getTitle().compareTo(arg1.getTitle());
		}
		
	}
	
	public static class DateComparator implements Comparator<Publication> {

		@Override
		public int compare(Publication arg0, Publication arg1) {
			if (arg0 == null && arg1 == null) {
				return 0;
			}
			if (arg0 == null) {
				return 1;
			}
			if (arg1 == null) {
				return -1;
			}
			Integer i1 = arg0.getYear();
			Integer i2 = arg1.getYear();
			return -i1.compareTo(i2);
		}
		
	}
}