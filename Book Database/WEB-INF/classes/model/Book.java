/**
 * 
 */
package model;

/**
 * 
 */
public class Book {
	
	private int bookID;
	private String title;
	private String author;
	private int pages;
	/**
	 * 
	 */
	public Book() {
		this.bookID=1;
		this.title="No title";
		this.author="No author";
		this.pages = 0;
		
	}
	/**
	 * @param bookID
	 * @param title
	 * @param author
	 * @param pages
	 */
	public Book(int bookID, String title, String author, int pages) {
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.pages = pages;
	}
	/**
	 * @return the bookID
	 */
	public int getBookID() {
		return bookID;
	}
	/**
	 * @param bookID the bookID to set
	 */
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}
	/**
	 * @param pages the pages to set
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String toString() {
		return "Book [bookID=" + bookID + ", title=" + title + ", author="
				+ author + ", pages=" + pages + "]";
	}

}
