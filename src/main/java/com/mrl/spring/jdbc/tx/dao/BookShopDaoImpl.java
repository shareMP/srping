package com.mrl.spring.jdbc.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mrl.spring.jdbc.tx.beans.Account;
import com.mrl.spring.jdbc.tx.beans.Book;
import com.mrl.spring.jdbc.tx.beans.BookStock;
import com.mrl.spring.jdbc.tx.exception.AccountExeption;
import com.mrl.spring.jdbc.tx.exception.BookStockException;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Double findBookPriceByIsbn(String isbn) {
		String sql = "SELECT price FROM book WHERE isbn = ?";
		return jdbcTemplate.queryForObject(sql, Double.class, isbn);
	}

	@Override
	public void updateBookStock(String isbn) {

		// ¼ì²éÊéµÄ¿â´æ
		String sqlSto = "SELECT stock FROM book_stock WHERE isbn=?";
		Integer stock = jdbcTemplate.queryForObject(sqlSto, Integer.class,isbn);
		if (stock == 0) {
			throw new BookStockException("¿â´æ²»×ã");
		}

		String sql = "UPDATE book_stock SET stock = stock - 1 WHERE isbn = ?";
		jdbcTemplate.update(sql, isbn);
	}

	@Override
	public void updateUserAccount(String name, Double price) {

		// ¼ì²éÓà¶î
		String sqlBalance = "SELECT balance FROM account WHERE name=?";
		Double balacne = jdbcTemplate.queryForObject(sqlBalance, Double.class,name);
		if (balacne < price) {
			throw new AccountExeption("ÕË»§Óà¶î²»×ã");
		}

		String sql = "UPDATE account SET balance=balance-? WHERE name=?";
		jdbcTemplate.update(sql, price, name);
	}

	@Override
	public void insertBook(Book book) {
		String sql = "INSERT INTO book(id,bookname,isbn,price) VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, book.getId(), book.getBookname(), book.getIsbn(), book.getPrice());
	}

	@Override
	public void insertBookStock(BookStock stock) {
		String sql = "INSERT INTO book_stock(id,isbn,stock) VALUES(?,?,?)";
		jdbcTemplate.update(sql, stock.getId(), stock.getIsbn(), stock.getStock());
	}

	@Override
	public void insertAccount(Account account) {
		String sql = "INSERT INTO account(id,name,balance) VALUES(?,?,?)";
		jdbcTemplate.update(sql, account.getId(), account.getName(), account.getBalacne());
	}

}
