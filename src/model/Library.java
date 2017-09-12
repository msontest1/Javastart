package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable{
	private static final long serialVersionUID = 4860599209931072434L;
	
	private Map<String, Publication> publications;
	private Map<String, LibraryUser> users;
	
	public Library() {
		publications = new HashMap<>();
		users = new HashMap<>();
	}
	
	public Map<String, Publication> getPublications() {
		return publications;
	}
	
	public Map<String, LibraryUser> getUsers() {
		return users;
	}

	public int getPublicationNumber() {
		return publications.size();
	}

	public void addBook(Book book) {
		addPublication(book);
	}
	
	public void addUser(LibraryUser user) {
		users.put(user.getPesel(), user);
	}
	
	public void addMagazine(Magazine magazine) {
		addPublication(magazine);
	}
	
	public void removePublication(Publication pub) {
		if (publications.containsValue(pub)) {
			publications.remove(pub.getTitle());
		}
	}
	
	private void addPublication(Publication pub) {
		publications.put(pub.getTitle(), pub);
	}

	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Publication p : publications.values()) {
            builder.append(p);
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