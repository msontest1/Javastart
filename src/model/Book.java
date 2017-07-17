package model;

public class Book extends Publication{
	private String author;
    private int pages;
    private String isbn;
 
    public String getIsbn() {
        return isbn;
    }
 
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
 
    public int getPages() {
        return pages;
    }
 
    public void setPages(int pages) {
        this.pages = pages;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String title, String author, int year, int pages, String publisher,
            String isbn) {
        setTitle(title);
        setAuthor(author);
        setYear(year);
        setPages(pages);
        setPublisher(publisher);
        setIsbn(isbn);
    }
 
    public void printInfo() {
        String info = getTitle() + "; " + getAuthor() + "; " + getYear() + "; " + getPages()
                + "; " + getPublisher() + "; " + getIsbn();
        System.out.println(info);
    }
}