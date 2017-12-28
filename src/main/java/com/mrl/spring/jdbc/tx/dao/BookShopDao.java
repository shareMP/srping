package com.mrl.spring.jdbc.tx.dao;

import com.mrl.spring.jdbc.tx.beans.Account;
import com.mrl.spring.jdbc.tx.beans.Book;
import com.mrl.spring.jdbc.tx.beans.BookStock;

public interface BookShopDao {
	
	/**根据书号获取价格
	 * @param isbn
	 * @return
	 */
	public Double findBookPriceByIsbn(String isbn);

	
	/**
	 * 书号对应的库存  -1
	 * @param isbn
	 */
	public void updateBookStock(String isbn);
	
	
	/**
	 * 更新用户余额
	 * 余额-price
	 * @param name
	 * @param price
	 */
	public void updateUserAccount(String name,Double price);
	
	public void insertBook(Book book);
	
	public void insertBookStock(BookStock stock);
	
	public void insertAccount(Account account);
}
