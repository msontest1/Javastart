package model;

import java.io.Serializable;

public class Library implements Serializable{
	private static final long serialVersionUID = 4860599209931072434L;
	
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
	
	private void addPublication(Publication publication) throws ArrayIndexOutOfBoundsException {
		if (publicationNumber == MAX_PUBLICATIONS) {
			throw new ArrayIndexOutOfBoundsException("MAX_PUBLICATIONS " + MAX_PUBLICATIONS);
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
}