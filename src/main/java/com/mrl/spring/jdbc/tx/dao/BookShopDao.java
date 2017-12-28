package com.mrl.spring.jdbc.tx.dao;

import com.mrl.spring.jdbc.tx.beans.Account;
import com.mrl.spring.jdbc.tx.beans.Book;
import com.mrl.spring.jdbc.tx.beans.BookStock;

public interface BookShopDao {
	
	/**������Ż�ȡ�۸�
	 * @param isbn
	 * @return
	 */
	public Double findBookPriceByIsbn(String isbn);

	
	/**
	 * ��Ŷ�Ӧ�Ŀ��  -1
	 * @param isbn
	 */
	public void updateBookStock(String isbn);
	
	
	/**
	 * �����û����
	 * ���-price
	 * @param name
	 * @param price
	 */
	public void updateUserAccount(String name,Double price);
	
	public void insertBook(Book book);
	
	public void insertBookStock(BookStock stock);
	
	public void insertAccount(Account account);
}
