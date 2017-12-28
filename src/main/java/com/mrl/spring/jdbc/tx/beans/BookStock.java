package com.mrl.spring.jdbc.tx.beans;

/**
 * @author lwqMR
 * ¿â´æ
 */
public class BookStock {
	private String id;
	private String isbn;
	private Integer stock;
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
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "BookStock [id=" + id + ", isbn=" + isbn + ", stock=" + stock + "]";
	}
	
	
}
