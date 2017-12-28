package com.mrl.spring.jdbc.tx.beans;

/**
 * @author lwqMR
 *  È
 */
public class Book {
	private String id;
	private String isbn;
	private Double price;
	private String bookname;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", price=" + price + ", bookname=" + bookname + "]";
	}
	
	
}
